<template>
  <Page>
    <ActionBar title="Warlords Classic Battle Odds Calculator" />
      <StackLayout class="home-panel">
        <!--Defender-->
          <GridLayout columns="auto,auto,auto,auto,auto,auto,auto,auto"
            rows="auto, auto, auto, auto, auto, auto, auto, auto, auto">

            <Label row="0" col="0" colSpan="4" text="Defender" style="padding-left: 5" />
            <Label row="0" col="4" colSpan="4" textAlignment="right" >{{ defWinPercent | percentConverter }} </Label>

            <TextField  v-for="(item, index) in defender" 
              v-model="defender[index]" 
              :key="'d'+index"
              :col="index % 8"
              :row="1 + 2 * Math.trunc(index / 8)" 
              maxLength="1" 
              keyboardType="number"
              returnKeyType="next"
              class="-border unit-strength"  
              hint=""
              ref="defender"
              @textChange="onChangeDefender(index)" 
              />

            <Label v-for="(item, index) in defStats" 
              :text="item | percentConverter" 
              :row="2 + 2 * Math.trunc(index / 8)" 
              :col="index % 8" 
              :key="'ds'+index" 
              class="percent" />
          </GridLayout>

        <!--Attacker-->
        <StackLayout class="nt-form">
          <GridLayout columns="auto,auto,auto,auto,auto,auto,auto,auto" rows="auto,auto, auto" style="margin-top: 15dp" >
            <Label row="0" col="0" colSpan="4" text="Attacker"  style="padding-left: 5" />
            <Label row="0" col="4" colSpan="4" textAlignment="right" :text="attWinPercent | percentConverter" />

            <TextField  v-for="(item, index) in attacker" 
              v-model="attacker[index]" 
              :key="'a'+index"
              :col="index"
              row="1"
              maxLength="1" 
              keyboardType="number"
              returnKeyType="next"
              class="-border unit-strength"  
              hint=""
              ref="attacker"
              @textChange="onChangeAttacker(index)" />

            <Label v-for="(item, index) in attStats" 
              :text="item | percentConverter" 
              :col="index" 
              :key="'as'+index"
              row="2"
              class="percent" />

          </GridLayout>
          <GridLayout rows="auto" columns="*,*">
            <Button class="-primary" row="0" col="0" text="CALCULATE" 
              @tap="onCalculate()" ref="calculate"></Button>
            <Button class="" row="0" col="1" text="CLEAR" @tap="onClear()"  ref="clear"></Button>
          </GridLayout>
        </StackLayout>
      </StackLayout>
  </Page>
</template>

<script>
  import calculateBattle from "./calculate-battle";
  const intl = require("nativescript-intl");
  // let wasEmpty = false;

  export default {
    data() {
      return {
        defender: new Array(32).fill(''),
        attacker: new Array(8).fill(''),
        defStats: new Array(32).fill(0),
        attStats: new Array(8).fill(0),
        defWinPercent: 0,
        attWinPercent: 0
      };
    },
    filters: {
      percentConverter: function(value) {
        let formattedValue = '';
        if (typeof(value) != "number") {
          formattedValue = '';
        } else if (value >= 0.1) {
          formattedValue = new intl.NumberFormat('en-us', { 
              style: 'percent', maximumFractionDigits: 1,
              minimumSignificantDigits: 3 }).format(value);
        } else if (value > 0) {
          formattedValue = new intl.NumberFormat('en-us', { 
              style: 'percent', maximumFractionDigits: 2,
              minimumSignificantDigits: 3 }).format(value);
        }
        return formattedValue;
      }
    },
    methods: {
      onCalculate() {
        const defArmy = [];
        const attArmy = [];
        for (let strength of this.defender) if (strength) defArmy.push(strength);
        for (let strength of this.attacker) if (strength) attArmy.push(strength);

        const result = calculateBattle(defArmy, attArmy);

        this.defWinPercent = 1 - result[0];
        this.attWinPercent = 1 - result[65];
        this.defStats.forEach((x, i, a) => (a[i] = result[1 + i * 2] + result[2 + i * 2]));
        this.attStats.forEach((x, i, a) => (a[i] = result[66 + i * 2] + result[67 + i * 2]));
      },
      onChangeDefender(index){
        if (!this.defender[index]) return;
        if (index < 31) this.$refs.defender[index + 1].nativeView.focus();
        else this.$refs.attacker[0].nativeView.focus();
      },
      onChangeAttacker(index){
        if (!this.attacker[index]) return;
        if (index < 7) this.$refs.attacker[index + 1].nativeView.focus();
        else this.$refs.calculate.nativeView.focus();
      },
      onFocus(args){
        // console.log("onFocus")
      },
      onClear() {    
        this.defWinPercent = 0;
        this.attWinPercent = 0;
        for (let i = 8; i-- > 0;) {
          this.attacker[i] = "";
          this.attStats[i] = 0;
        }
        for (let i = 32; i-- > 0;) {
          this.defender[i] = "";
          this.defStats[i] = 0;
        }
        this.$refs.defender[0].nativeView.focus();
      }
    }
  };
</script>

<style scoped>
  .home-panel {
    vertical-align: top;
    font-size: 20;
    margin: 14;
  }

  .description-label {
    margin-bottom: 15;
  }

  .unit-strength {
    height: 44;
    width: 44;
    margin-top: 3;
    margin-bottom: 3;
    margin-right: 2;
    margin-left: 2;
    padding-top: 1;
    padding-right: 1;
    padding-bottom: 1;
    padding-left: 1;
    text-align: center;
    font-size: 20;
  }

  .percent {
    vertical-align: center;
    font-size: 14;
    text-align: center;
    color: gray
  }
</style>