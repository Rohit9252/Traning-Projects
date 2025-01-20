package helloworld;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.InputStream;
import java.io.OutputStream;

public class DemoClass {



    private Double instanceVar = Math.random();
    private  static  Double staticVar = Math.random();


    public  void  getDetails(){
        Double localVar = Math.random();
        System.out.println("Local Variable: " + localVar);
        System.out.println("Instance Variable: " + instanceVar);
        System.out.println("Static Variable: " + staticVar);
    }



    public void getOutput(InputStream input, OutputStream output, Context context) throws Exception {
        Thread.sleep(10000);
        System.out.println(context.getFunctionName());
        System.out.println(context.getAwsRequestId());
        System.out.println(context.getRemainingTimeInMillis());
        System.out.println(context.getMemoryLimitInMB());
        System.out.println(context.getLogGroupName());
        System.out.println(context.getLogStreamName());
        System.out.println(context.getIdentity());
        System.out.println(context.getLogger());

        int letter = 0;
        while((letter = input.read()) != -1){
            output.write(Character.toUpperCase(letter));
        }
    }



}
