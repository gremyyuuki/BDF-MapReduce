package com.opstty.mapper;

import com.opstty.reducer.IntSumReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Calendar;
import java.util.StringTokenizer;

public class TokenizerMapperDistrictOld extends Mapper<Object, Text, Text, IntWritable> {
    private final static Text one = new Text("1");
    private IntWritable word = new IntWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] itr = value.toString().split(";");

        // fill empty values with _
        for (int i = 0; i < itr.length; i += 1) {
            if (itr[i].equals("ANNEE PLANTATION") || itr[i].equals("ARRONDISSEMENT")) {
                return;
            }
            if (itr[i].length() == 0 || equals("")) {
                itr[i] = "_";
            }
        }

        // if value of height is empty, then return (ignore)
        int year;
        try {
            year = (Integer.parseInt(itr[5]));
        } catch (NumberFormatException e) {
            return;
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - year;

        word.set(age);
        one.set(itr[1]);
        context.write(one, word);
    }
}
