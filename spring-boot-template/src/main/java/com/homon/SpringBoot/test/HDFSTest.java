package com.homon.SpringBoot.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * Created by HongMong on 2017/8/16.
 */
public class HDFSTest {

    //输入
    public static final String INPUT_PATH = "/";
    //输出
    public static final String OUTPUT_PATH = "";

    public static void main (String [] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuratitn = getConfiguratitn();

        FileSystem fileSystem = FileSystem.get(configuratitn);
        Path inputPath = new Path(INPUT_PATH);
        fileSystem.open(inputPath);
        Path outputPath = new Path(OUTPUT_PATH);
        if(fileSystem.exists(outputPath)){
            fileSystem.delete(outputPath,true);
        }

        //创建任务
        Job job = Job.getInstance(configuratitn,"AccessLogUserAction");
        job.setJarByClass(HDFSTest.class);

        //指定输入目录
        FileInputFormat.setInputPaths(job,inputPath);
        //指定对输入数据进行格式化处理的类
        job.setInputFormatClass(TextInputFormat.class);
        //指定自定义的Mapper类
        job.setMapperClass(AccessLogUserActionMapper.class);
        //指定map输出的<k,v>的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //设置要运行的Reduce的数量
        job.setNumReduceTasks(1);
        //指定自定义的Reduce类
        job.setReducerClass(AccessLogUserActionReduce.class);
        //指定reduce输出的<k,v>的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //指定输出目录
        FileOutputFormat.setOutputPath(job,outputPath);
        // 1.9:指定对输出数据进行格式化处理的类（可以省略）
        job.setOutputFormatClass(TextOutputFormat.class);
        //提交作业
        boolean success = job.waitForCompletion(true);
        if(success){
            System.out.println("Success");
            System.exit(0);
        }else {
            System.out.println("Failed");
            System.exit(1);
        }
    }

    /**
     * 获取HDFS配置信息
     * @return
     */
    public static Configuration getConfiguratitn(){
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS","hdfs://123.56.64.20:9000");
        return configuration;
    }

    /**
     * 自定义map类,数据切割/处理
     */
    public static class AccessLogUserActionMapper extends Mapper {

        private Text k_word = new Text();
        private Text v_word = new Text();

        @Override
        protected void map(Object key, Object value, Context context) throws IOException, InterruptedException {
            String[] split = value.toString().split(" ");
            for (String  string : split) {
                if(string.indexOf("access_phone") > -1){
                    String[] accessPhone = string.split("=");

                }
            }
        }
    }

    /**
     * 自定义reduce类,数据汇总
     */
    public static class AccessLogUserActionReduce extends Reducer{

        private Text outKey = new Text();
        private Text outValue = new Text();

        protected void reduce(Text key, Iterable values, Context context) throws IOException, InterruptedException {
            if(key == null) return;

            outKey.set(key.toString());
//            outValue.set();
        }
    }
}
