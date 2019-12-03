const observableModule = require("tns-core-modules/data/observable");
const collectStatistics = require("./collect-statistics");
const intl = require("nativescript-intl");

const percentConverter = {
    toView(value) {
        let formattedValue = '';
        if (typeof(value) != "number") formattedValue = '';
        else if (value >= 0.1) formattedValue = new intl.NumberFormat('en-us', { 
                style: 'percent', maximumFractionDigits: 1,
                minimumSignificantDigits: 3 }).format(value);
        else if (value > 0) formattedValue = new intl.NumberFormat('en-us', { 
                style: 'percent', maximumFractionDigits: 2,
                minimumSignificantDigits: 3 }).format(value);
        return formattedValue;
    }
}

function HomeViewModel() {
    const emptyArray8 = ['', '', '', '', '', '', '', ''];
    const emptyArray32 = emptyArray8.concat(emptyArray8, emptyArray8, emptyArray8);

    const viewModel = observableModule.fromObject({
        /* Add your view model properties here */
        percentConverter: percentConverter,
        simulations: 100000,
        attacker: emptyArray8.slice(),
        defender: emptyArray32.slice(),
        statistics: { attacker: emptyArray8, defender: emptyArray32 },
        attackerWinPercent: '',
        defenderWinPercent: '',
        onCalculate: function() {
            viewModel.set('defenderWinPercent', '');
            viewModel.set('attackerWinPercent', '');
            viewModel.set('statistics', {attacker: emptyArray8, defender: emptyArray32});

            const simulations = viewModel.get('simulations');
            const statistics = collectStatistics(
                viewModel.get('attacker'), 
                viewModel.get('defender'), 
                simulations);
            viewModel.set('statistics', statistics);

            const attackerWinPercent = statistics.attacker.reduce(function(sum, current) { return sum + current; }, 0);
            viewModel.set('attackerWinPercent',attackerWinPercent);
            const defenderWinPercent = statistics.defender.reduce(
                function(sum, current) { return sum + current; }, 0);
            viewModel.set('defenderWinPercent', defenderWinPercent);            
            },
        onClear: function() {
            //console.log('Clear');
            viewModel.set('defenderWinPercent', '');
            viewModel.set('attackerWinPercent', '');
            viewModel.set('statistics', {attacker: emptyArray8, defender: emptyArray32});
            //viewModel.set('attacker', emptyArray8.slice());
            //viewModel.set('defender', emptyArray32.slice());
        }
    });
    return viewModel;
}

module.exports = HomeViewModel;
