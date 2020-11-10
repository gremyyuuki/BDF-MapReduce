package com.opstty.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxHeightReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {

        // get the max height
        int max = 0;
        for (IntWritable val : values) {
            int tmp = val.get();
            if (tmp > max)
            {
                max = tmp;
            }
        }
        result.set(max);
        context.write(key, result);
    }
}
