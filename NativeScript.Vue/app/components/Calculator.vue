<template>
    <Page>
        <ActionBar title="Warlords Classic Battle Odds Calculator" />
        <ScrollView>
            <StackLayout class="home-panel">
                <!--Defender-->
                <StackLayout>
                    <GridLayout style="margin-top: 15dp" columns="*, *"
                        rows="auto" backgroundColor="lightgray">
                        <Label row="0" col="0" text="Defender" />
                        <Label row="0" col="1" textAlignment="right"
                            :text="defWinPercent" />
                    </GridLayout>
                    <GridLayout columns="*,*,*,*,*,*,*,*"
                        rows="auto, auto, auto, auto, auto, auto, auto, auto">
                        <TextField v-model="defender[0]"
                            class="-border unit-strength" row="0" col="0"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[1]"
                            class="-border unit-strength" row="0" col="1"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[2]"
                            class="-border unit-strength" row="0" col="2"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[3]"
                            class="-border unit-strength" row="0" col="3"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[4]"
                            class="-border unit-strength" row="0" col="4"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[5]"
                            class="-border unit-strength" row="0" col="5"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[6]"
                            class="-border unit-strength" row="0" col="6"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[7]"
                            class="-border unit-strength" row="0" col="7"
                            hint="" maxLength="1" keyboardType="number" />
                        <Label class="percent" row="1" col="0"
                            :text="defStats[0]" />
                        <Label class="percent" row="1" col="1"
                            :text="defStats[1]" />
                        <Label class="percent" row="1" col="2"
                            :text="defStats[2]" />
                        <Label class="percent" row="1" col="3"
                            :text="defStats[3]" />
                        <Label class="percent" row="1" col="4"
                            :text="defStats[4]" />
                        <Label class="percent" row="1" col="5"
                            :text="defStats[5]" />
                        <Label class="percent" row="1" col="6"
                            :text="defStats[6]" />
                        <Label class="percent" row="1" col="7"
                            :text="defStats[7]" />
                        <TextField v-model="defender[8]"
                            class="-border unit-strength" row="2" col="0"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[9]"
                            class="-border unit-strength" row="2" col="1"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[10]"
                            class="-border unit-strength" row="2" col="2"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[11]"
                            class="-border unit-strength" row="2" col="3"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[12]"
                            class="-border unit-strength" row="2" col="4"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[13]"
                            class="-border unit-strength" row="2" col="5"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[14]"
                            class="-border unit-strength" row="2" col="6"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[15]"
                            class="-border unit-strength" row="2" col="7"
                            hint="" maxLength="1" keyboardType="number" />
                        <Label class="percent" row="3" col="0"
                            :text="defStats[8]" />
                        <Label class="percent" row="3" col="1"
                            :text="defStats[9]" />
                        <Label class="percent" row="3" col="2"
                            :text="defStats[10]" />
                        <Label class="percent" row="3" col="3"
                            :text="defStats[11]" />
                        <Label class="percent" row="3" col="4"
                            :text="defStats[12]" />
                        <Label class="percent" row="3" col="5"
                            :text="defStats[13]" />
                        <Label class="percent" row="3" col="6"
                            :text="defStats[14]" />
                        <Label class="percent" row="3" col="7"
                            :text="defStats[15]" />
                        <TextField v-model="defender[16]"
                            class="-border unit-strength" row="4" col="0"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[17]"
                            class="-border unit-strength" row="4" col="1"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[18]"
                            class="-border unit-strength" row="4" col="2"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[19]"
                            class="-border unit-strength" row="4" col="3"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[20]"
                            class="-border unit-strength" row="4" col="4"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[21]"
                            class="-border unit-strength" row="4" col="5"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[22]"
                            class="-border unit-strength" row="4" col="6"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[23]"
                            class="-border unit-strength" row="4" col="7"
                            hint="" maxLength="1" keyboardType="number" />
                        <Label class="percent" row="5" col="0"
                            :text="defStats[16]" />
                        <Label class="percent" row="5" col="1"
                            :text="defStats[17]" />
                        <Label class="percent" row="5" col="2"
                            :text="defStats[18]" />
                        <Label class="percent" row="5" col="3"
                            :text="defStats[19]" />
                        <Label class="percent" row="5" col="4"
                            :text="defStats[20]" />
                        <Label class="percent" row="5" col="5"
                            :text="defStats[21]" />
                        <Label class="percent" row="5" col="6"
                            :text="defStats[22]" />
                        <Label class="percent" row="5" col="7"
                            :text="defStats[23]" />
                        <TextField v-model="defender[24]"
                            class="-border unit-strength" row="6" col="0"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[25]"
                            class="-border unit-strength" row="6" col="1"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[26]"
                            class="-border unit-strength" row="6" col="2"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[27]"
                            class="-border unit-strength" row="6" col="3"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[28]"
                            class="-border unit-strength" row="6" col="4"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[29]"
                            class="-border unit-strength" row="6" col="5"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[30]"
                            class="-border unit-strength" row="6" col="6"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="defender[31]"
                            class="-border unit-strength" row="6" col="7"
                            hint="" maxLength="1" keyboardType="number" />
                        <Label class="percent" row="7" col="0"
                            :text="defStats[24]" />
                        <Label class="percent" row="7" col="1"
                            :text="defStats[25]" />
                        <Label class="percent" row="7" col="2"
                            :text="defStats[26]" />
                        <Label class="percent" row="7" col="3"
                            :text="defStats[27]" />
                        <Label class="percent" row="7" col="4"
                            :text="defStats[28]" />
                        <Label class="percent" row="7" col="5"
                            :text="defStats[29]" />
                        <Label class="percent" row="7" col="6"
                            :text="defStats[30]" />
                        <Label class="percent" row="7" col="7"
                            :text="defStats[31]" />
                    </GridLayout>
                </StackLayout>
                <!--Attacker-->
                <StackLayout>
                    <GridLayout style="margin-top: 15dp" columns="*, *"
                        rows="auto" backgroundColor="lightgray">
                        <Label row="0" col="0" text="Attacker" />
                        <Label row="0" col="1" textAlignment="right"
                            :text="attWinPercent" />
                    </GridLayout>
                    <GridLayout columns="*,*,*,*,*,*,*,*"
                        rows="auto, auto, auto, auto">
                        <TextField v-model="attacker[0]"
                            class="-border unit-strength" row="0" col="0"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[1]"
                            class="-border unit-strength" row="0" col="1"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[2]"
                            class="-border unit-strength" row="0" col="2"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[3]"
                            class="-border unit-strength" row="0" col="3"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[4]"
                            class="-border unit-strength" row="0" col="4"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[5]"
                            class="-border unit-strength" row="0" col="5"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[6]"
                            class="-border unit-strength" row="0" col="6"
                            hint="" maxLength="1" keyboardType="number" />
                        <TextField v-model="attacker[7]"
                            class="-border unit-strength" row="0" col="7"
                            hint="" maxLength="1" keyboardType="number" />
                        <Label class="percent" row="1" col="0"
                            :text="attStats[0]" />
                        <Label class="percent" row="1" col="1"
                            :text="attStats[1]" />
                        <Label class="percent" row="1" col="2"
                            :text="attStats[2]" />
                        <Label class="percent" row="1" col="3"
                            :text="attStats[3]" />
                        <Label class="percent" row="1" col="4"
                            :text="attStats[4]" />
                        <Label class="percent" row="1" col="5"
                            :text="attStats[5]" />
                        <Label class="percent" row="1" col="6"
                            :text="attStats[6]" />
                        <Label class="percent" row="1" col="7"
                            :text="attStats[7]" />
                    </GridLayout>
                    <GridLayout rows="auto" columns="*,*">
                        <Button class="-primary" row="0" col="0"
                            text="CALCULATE" @tap="onCalculate()">
                        </Button>
                        <Button class="" row="0" col="1" text="CLEAR"
                            @tap="onClear()"></Button>
                    </GridLayout>
                </StackLayout>
            </StackLayout>
        </ScrollView>
    </Page>
</template>

<script>
    import collectStatistics from "./collect-statistics";
    export default {
        data() {
            return {
                defender: [
                    "9",
                    "8",
                    "7",
                    "7",
                    "7",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
                ],
                attacker: ["9", "8", "", "", "", "", "", ""],
                defStats: [
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
                ],
                attStats: ["33.8%", "", "", "", "", "", "", ""],
                defWinPercent: "50.00%",
                attWinPercent: "50.00%"
            };
        },
        methods: {
            onCalculate() {
                console.log("Calculate");
                const statistics = collectStatistics(
                    this.attacker,
                    this.defender,
                    1000
                );
                //console.dir(statistics);

                this.defStats.forEach(
                    (x, i, a) => (a[i] = statistics.defender[i] * 100)
                );

                this.attStats.forEach(
                    (x, i, a) => (a[i] = statistics.attacker[i] * 100)
                );

                this.attWinPercent =
                    100 *
                    statistics.attacker.reduce((sum, current) => sum +
                        current, 0);
                this.defWinPercent =
                    100 *
                    statistics.defender.reduce((sum, current) => sum +
                        current, 0);
            },
            onClear() {
                
                this.defWinPercent = "";
                this.attWinPercent = "";
                for (let i = 8; i-- > 0;) {
                    this.attacker[i] = "";
                    this.attStats[i] = "";
                }
                for (let i = 32; i-- > 0;) {
                    this.defender[i] = "";
                    this.defStats[i] = "";
                }
            }
        }
    };
</script>

<style scoped>
    .home-panel {
        vertical-align: center;
        font-size: 20;
        margin: 15;
    }

    .description-label {
        margin-bottom: 15;
    }

    .unit-strength {
        height: 45dp;
        width: 45dp;
        margin-top: 3dp;
        margin-bottom: 3dp;
        margin-right: 4dp;
        margin-left: 4dp;
        padding-top: 2dp;
        padding-right: 2dp;
        padding-bottom: 2dp;
        padding-left: 2dp;
        text-align: center;
        font-size: 20dp;
    }

    .percent {
        vertical-align: center;
        font-size: 14;
        text-align: center;
        color: gray
    }
</style>