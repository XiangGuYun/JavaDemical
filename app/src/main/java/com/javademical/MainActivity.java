package com.javademical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //计算结果格式化
        caseFormatResult();
        //BigDecimal的API
        caseBigDecimalAPI();
    }

    /**
     * RoundingMode 取舍模式
     * 例子:10/1.1≈9.9
     * ceiling 上限模式 10/1.1=10
     * floor 下限模式 10/1.1=9
     */
    private void caseBigDecimalAPI() {
        NumberFormat format2 = NumberFormat.getNumberInstance();
        format2.setMaximumFractionDigits(2);//保留两位
        BigDecimal decimal1 = new BigDecimal(-100);
        BigDecimal decimal2 = new BigDecimal(30);
        BigDecimal decimal3 = new BigDecimal(10);
        BigDecimal decimal4 = new BigDecimal(1.1);
        BigDecimal decimal5 = new BigDecimal(1.2);
        int test1 = decimal1.abs().intValue();
        int test2 = decimal1.add(decimal2).intValue();
        int test3 = decimal2.divide(decimal3, RoundingMode.FLOOR).intValue();
        int test4 = decimal2.multiply(decimal3).intValue();
        int test5 = decimal2.subtract(decimal3).intValue();
        double test6 = decimal4.multiply(decimal5).doubleValue();
        String test7 = format2.format(decimal4.divide(decimal3, RoundingMode.FLOOR));
        double test8 = decimal3.divide(decimal4, RoundingMode.HALF_EVEN).doubleValue();
        Log.d("Test",
        "取绝对值:" + test1+"\n"+
            "整数相加:"+test2+"\n"+
            "整数相除"+test3+"\n"+
            "整数相乘"+test4+"\n"+
            "整数相减"+test5+"\n"+
            "小数相乘"+test6+"\n"+
            "小数除以整数"+test7+"\n"+
            "整数除以整数"+test8+" "+format2.format(10/1.1)+"\n"+
            "比较:"+decimal4.compareTo(decimal5)+" "+(1.1>1.2));
    }

    /**
     * 计算贷款利息
     * FractionDigit:小数
     * Locale:地区,场所
     * interest:利息
     */
    private void caseFormatResult() {
        //获取当前默认的货币格式RMB
        NumberFormat rmb = NumberFormat.getCurrencyInstance();
        rmb.setMaximumFractionDigits(3);//如果不设置的话currency默认保留两位
        //美元
        NumberFormat dollar = NumberFormat.getCurrencyInstance(Locale.US);

        //百分比
        NumberFormat percent = NumberFormat.getPercentInstance();
        //小数点最多保留
        percent.setMaximumFractionDigits(3);

        //贷款金额
        BigDecimal loanMoney = new BigDecimal(12345.3243);
        //利率
        BigDecimal interestRate = new BigDecimal(0.004);

        //利息
        BigDecimal interest = loanMoney.multiply(interestRate);
        Log.d("Test","贷款金额¥:" + rmb.format(loanMoney));
        Log.d("Test","贷款金额$:" + dollar.format(loanMoney));
        Log.d("Test","贷款利率:"+percent.format(interestRate));
        Log.d("Test","贷款利息:"+rmb.format(interest));
    }
}
