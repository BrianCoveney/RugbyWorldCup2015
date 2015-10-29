package com.cit.briancoveney.rugbyworldcup;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private EditText edTSemi1, edTSemi2, edTSemi3, edTSemi4, edTF1, edTF2, edTW,
            edTQrt1, edTQrt2, edTQrt3, edTQrt4, edTQrt5, edTQrt6, edTQrt7, edTQrt8;

    private ArrayList<EditText> countryName;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryName = new ArrayList<EditText>();


        countryEditTextReferences();
        currentCountryTextWatcher();
        teamSelected();



        final Round semiFinals = new Round();
        final Round finalGames = new Round();
        final Round theWinner = new Round();


        final Match match1 = new Match(Team.WAL, Team.RSA);
        final Match match2 = new Match(Team.NZL, Team.FRA);
        final Match match3 = new Match(Team.IRE, Team.ARG);
        final Match match4 = new Match(Team.AUS, Team.SCT);
        final Match match5 = new Match(Team.ARG, Team.URG);
        final Match match6 = new Match(Team.ENG, Team.FIJ);
        final Match match7 = new Match(Team.ROM, Team.CAN);
        final Match match8 = new Match(Team.JPN, Team.SAM);


        semiFinals.addMatch(match1);
        semiFinals.addMatch(match2);
        semiFinals.addMatch(match3);
        semiFinals.addMatch(match4);
        semiFinals.addMatch(match5);
        semiFinals.addMatch(match6);
        semiFinals.addMatch(match7);
        semiFinals.addMatch(match8);

        finalGames.addMatch(match1);
        finalGames.addMatch(match2);
        finalGames.addMatch(match3);
        finalGames.addMatch(match4);
        finalGames.addMatch(match5);
        finalGames.addMatch(match6);
        finalGames.addMatch(match7);
        finalGames.addMatch(match8);

        theWinner.addMatch(match1);
        theWinner.addMatch(match2);
        theWinner.addMatch(match3);
        theWinner.addMatch(match4);
        theWinner.addMatch(match5);
        theWinner.addMatch(match6);
        theWinner.addMatch(match7);
        theWinner.addMatch(match8);



        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    // For Quarter Finals
                    edTQrt1.setText(match1.chooseAWinner().toString());
                    edTQrt2.setText(match2.chooseAWinner().toString());
                    edTQrt3.setText(match3.chooseAWinner().toString());
                    edTQrt4.setText(match4.chooseAWinner().toString());
                    edTQrt5.setText(match5.chooseAWinner().toString());
                    edTQrt6.setText(match6.chooseAWinner().toString());
                    edTQrt7.setText(match7.chooseAWinner().toString());
                    edTQrt8.setText(match8.chooseAWinner().toString());


                    // For Semi Finals
                    ArrayList<Team> semis = semiFinals.playMatchesForSemis();
                    Match semi1 = new Match(semis.get(0), semis.get(1));
                    Match semi2 = new Match(semis.get(2), semis.get(3));
                    Match semi3 = new Match(semis.get(4), semis.get(5));
                    Match semi4 = new Match(semis.get(6), semis.get(7));
                    edTSemi1.setText(semi1.chooseAWinner().toString());
                    edTSemi2.setText(semi2.chooseAWinner().toString());
                    edTSemi3.setText(semi3.chooseAWinner().toString());
                    edTSemi4.setText(semi4.chooseAWinner().toString());



                    // For Finals
                    ArrayList<Team> finals = finalGames.playMatchesForFinals();
                    Match finals1 = new Match(finals.get(2), finals.get(1));
                    Match finals2 = new Match(finals.get(4), finals.get(5));
                    edTF1.setText(finals1.chooseAWinner().toString());
                    edTF2.setText(finals2.chooseAWinner().toString());


                    // For Winner
                    ArrayList<Team> winners = theWinner.playMatchesForRound();
                    Match myWinner = new Match(winners.get(2),winners.get(4));
                    edTW.setText(myWinner.chooseAWinner().toString());


                }else{
                    edTQrt1.setText(null); edTQrt2.setText(null);
                    edTQrt3.setText(null); edTQrt4.setText(null);
                    edTQrt5.setText(null); edTQrt6.setText(null);
                    edTQrt7.setText(null); edTQrt8.setText(null);
                    edTSemi1.setText(null); edTSemi2.setText(null);
                    edTSemi3.setText(null); edTSemi4.setText(null);
                    edTF1.setText(null); edTF2.setText(null); edTW.setText(null);
                }
            }
        });
    }



    public void teamSelected()
    {
        edTQrt1 = (EditText)findViewById(R.id.eTxtQrt1);
        edTQrt2 = (EditText)findViewById(R.id.eTxtQrt2);
        edTQrt3 = (EditText)findViewById(R.id.eTxtQrt3);
        edTQrt4 = (EditText)findViewById(R.id.eTxtQrt4);
        edTQrt5 = (EditText)findViewById(R.id.eTxtQrt5);
        edTQrt6 = (EditText)findViewById(R.id.eTxtQrt6);
        edTQrt7 = (EditText)findViewById(R.id.eTxtQrt7);
        edTQrt8 = (EditText)findViewById(R.id.eTxtQrt8);
        edTSemi1 = (EditText)findViewById(R.id.eTxtSemi1);
        edTSemi2 = (EditText)findViewById(R.id.eTxtSemi2);
        edTSemi3 = (EditText)findViewById(R.id.eTxtSemi3);
        edTSemi4 = (EditText)findViewById(R.id.eTxtSemi4);
        edTF1 = (EditText)findViewById(R.id.eTxtFinal1);
        edTF2 = (EditText)findViewById(R.id.eTxtFinal2);
        edTW = (EditText)findViewById(R.id.eTxtWinner);

        edTSemi1.addTextChangedListener(SemiTextWatcher);
        edTSemi2.addTextChangedListener(SemiTextWatcher);
        edTSemi3.addTextChangedListener(SemiTextWatcher);
        edTSemi4.addTextChangedListener(SemiTextWatcher);
        edTF1.addTextChangedListener(FinalTextWatcher);
        edTF2.addTextChangedListener(FinalTextWatcher);
        edTW.addTextChangedListener(WinerTextWatcher);
    }



    /**********************************

    Color text to match Country Colors

     ********************************** */

    //add all EditText to the ArrayList
    public void countryEditTextReferences()
    {

        countryName.add((EditText) findViewById(R.id.eTxtQrt1));
        countryName.add((EditText) findViewById(R.id.eTxtQrt2));
        countryName.add((EditText) findViewById(R.id.eTxtQrt3));
        countryName.add((EditText) findViewById(R.id.eTxtQrt4));
        countryName.add((EditText) findViewById(R.id.eTxtQrt5));
        countryName.add((EditText) findViewById(R.id.eTxtQrt6));
        countryName.add((EditText) findViewById(R.id.eTxtQrt7));
        countryName.add((EditText) findViewById(R.id.eTxtQrt8));
        countryName.add((EditText) findViewById(R.id.eTxtSemi1));
        countryName.add((EditText) findViewById(R.id.eTxtSemi2));
        countryName.add((EditText) findViewById(R.id.eTxtSemi3));
        countryName.add((EditText) findViewById(R.id.eTxtSemi4));
        countryName.add((EditText) findViewById(R.id.eTxtFinal1));
        countryName.add((EditText) findViewById(R.id.eTxtFinal2));
        countryName.add((EditText) findViewById(R.id.eTxtWinner));
    }


    //add listener to the current EditText
    private void currentCountryTextWatcher()
    {
        for(EditText currField : countryName)
        {
            currField.addTextChangedListener(new QuartersTextWatcher(currField));
        }
    }




    //The TextWatcher which is instantiated for each EditText for the Quarter Finals
    private class QuartersTextWatcher implements TextWatcher
    {
        private EditText text;


        public QuartersTextWatcher(EditText text) {

            this.text = text;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }



        //Change EditText text colour when entering Country Name Abbreviations
        @Override
        public void afterTextChanged(Editable e)
        {
            if(e.toString().equalsIgnoreCase(Team.IRE.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.green));
            }else if(e.toString().equalsIgnoreCase(Team.ENG.toString())){
                this.text.setTextColor(getResources().getColor(R.color.white));
            }else if(e.toString().equalsIgnoreCase(Team.WAL.toString())){
                this.text.setTextColor(getResources().getColor(R.color.red));
            }else if(e.toString().equalsIgnoreCase(Team.SCT.toString())){
                this.text.setTextColor(getResources().getColor(R.color.blue));
            }else if(e.toString().equalsIgnoreCase(Team.ITA.toString())){
                this.text.setTextColor(getResources().getColor(R.color.cyan));
            }else if (e.toString().equalsIgnoreCase(Team.RSA.toString())){
                this.text.setTextColor(getResources().getColor(R.color.rsa_green));
            }else if(e.toString().equalsIgnoreCase(Team.SAM.toString())){
                this.text.setTextColor(getResources().getColor(R.color.sam_red));
            }else if(e.toString().equalsIgnoreCase(Team.JPN.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.jpn_red));
            }else if(e.toString().equalsIgnoreCase(Team.ROM.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.rom_blue));
            }else if(e.toString().equalsIgnoreCase(Team.CAN.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.red));
            }else if(e.toString().equalsIgnoreCase(Team.FIJ.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.cyan));
            }else if(e.toString().equalsIgnoreCase(Team.URG.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.cyan));
            }else if(e.toString().equalsIgnoreCase(Team.NZL.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.nzl_blue));
            }else if(e.toString().equalsIgnoreCase(Team.FRA.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.blue));
            }else if(e.toString().equalsIgnoreCase(Team.ARG.toString())) {
                this.text.setTextColor(getResources().getColor(R.color.cyan));
            }
        }
    }//end QuartersTextWatcher




    //Checking that Semi Final entries match their respective Quarter Final entries
    TextWatcher SemiTextWatcher = new TextWatcher()
    {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable e)
        {

            //Semi Result No. 1 must match either Quarter 1 or 2
            if (edTSemi1.getText().toString().equalsIgnoreCase(edTQrt1.getText().toString()) ||
                    (edTSemi1.getText().toString().equalsIgnoreCase(edTQrt2.getText().toString()))) {
                edTSemi1.setError(null);
            }else {
                edTSemi1.setError("Enter Team 1 or Team 2");
            }


            //Semi Result No. 2 must match either Quarter 3 or 4
            if (edTSemi2.getText().toString().equalsIgnoreCase(edTQrt3.getText().toString()) ||
                    (edTSemi2.getText().toString().equalsIgnoreCase(edTQrt4.getText().toString()))){
                edTSemi2.setError(null);
            }else {
                edTSemi2.setError("Enter Team 3 or Team 4");
            }

            //Semi Result No. 3 must match either Quarter 5 or 6
            if (edTSemi3.getText().toString().equalsIgnoreCase(edTQrt5.getText().toString()) ||
                    (edTSemi3.getText().toString().equalsIgnoreCase(edTQrt6.getText().toString()))){
                edTSemi3.setError(null);
            }else {
                edTSemi3.setError("Enter Team 5 or Team 6");
            }

            //Semi Result No. 4 must match either Quarter 7 or 8
            if (edTSemi4.getText().toString().equalsIgnoreCase(edTQrt7.getText().toString()) ||
                    (edTSemi2.getText().toString().equalsIgnoreCase(edTQrt8.getText().toString()))){
                edTSemi4.setError(null);
            }else {
                edTSemi4.setError("Enter Team 7 or Team 8");
            }

        } //end afterTextChanged

    };//end SemiTextWatcher



    //Checking that Final entries match their respective Semi Final entries
    TextWatcher FinalTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable e)
        {
            //Final Result No. 1 must match either Semis 1 or 2
            if (edTF1.getText().toString().equalsIgnoreCase(edTSemi1.getText().toString()) ||
                    (edTF1.getText().toString().equalsIgnoreCase(edTSemi2.getText().toString()))) {
                edTF1.setError(null);
            }else {
                edTF1.setError("Enter Team 1 or Team 2");
            }

            //Semi Result No. 2 must match either Semis 3 or 4
            if (edTF2.getText().toString().equalsIgnoreCase(edTSemi3.getText().toString()) ||
                    (edTF2.getText().toString().equalsIgnoreCase(edTSemi4.getText().toString()))){
                edTF2.setError(null);
            }else {
                edTF2.setError("Enter Team 3 or Team 4");
            }
        }

    };//end FinalTextWatcher



    //Checking that Winner entry matchrs eoth of the Semi Final entries
    TextWatcher WinerTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable e)
        {
            //The Winner must match either Final 1 or 2
            if (edTW.getText().toString().equalsIgnoreCase(edTF1.getText().toString()) ||
                    (edTW.getText().toString().equalsIgnoreCase(edTF2.getText().toString()))) {
                edTW.setError(null);
            }else {
                edTW.setError("Enter Team 1 or Team 2");
            }
        }

    };//end WinerTextWatcher


}//end MainApplication