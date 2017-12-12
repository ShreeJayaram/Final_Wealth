package com.example.shreenidhijayaram.wealthfactor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class chart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Bundle extras = getIntent().getExtras();
        float result = extras.getFloat("age",30);
        float stock_percent = (110 - result);
        float bond_percent = (100 - (110 - result));

        float investments[] = {stock_percent, bond_percent};

        String typeOfInvestment[] = {"Stocks", "Bonds"};


        List<PieEntry> pieEntries = new ArrayList<>();


        for (int i = 0; i < investments.length; i++) {
            pieEntries.add(new PieEntry(investments[i], typeOfInvestment[i]));

        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Proposed Investments based on Input");
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);
        PieData data = new PieData(dataSet);

        //get the chart

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();
    }
}



