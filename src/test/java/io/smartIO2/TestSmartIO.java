package io.smartIO2;

import com.plzEnterCompanyName.HDQS.io.smartIO2.*;

import java.util.ArrayList;
import java.util.List;

public class TestSmartIO {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        TEST_Info();
        TEST_Operation();
        Test_MessageManager();
        TEST_SmartIO();
        long cost = System.currentTimeMillis() - startTime;
        System.out.println("com.plzEnterCompanyName.HDQS.io.smartIO2 的测试成功完成于" + ' ' + cost + ' ' + "ms");
    }

    private static void Test_MessageManager() {

    }

    private static void TEST_SmartIO() {

    }

    private static void TEST_Operation() {
        // 测试简单顺序Operation
        Operation spo1 = new Operation("探索", new IntegerReceiver(1));
        Operation spo2 = new Operation("制作", new IntegerReceiver(2));
        Operation spo3 = new Operation("睡觉", new IntegerReceiver(3));
        List<Operation> spOperations = new ArrayList<>();
        spOperations.add(spo1);
        spOperations.add(spo2);
        spOperations.add(spo3);
        String input = "1";
        boolean pass = true;
        for (Operation o : spOperations) {
            if (o.look(input)) switch (o.getLookedValue()) {
                case "1" -> {
                    if (!"1".equals(o.getLookedValue())) {
                        pass = false;
                    }
                }
                case "2" -> {
                    if (!"2".equals(o.getLookedValue())) {
                        pass = false;
                    }
                }
                case "3" -> {
                    if (!"3".equals(o.getLookedValue())) {
                        pass = false;
                    }
                }
                default -> throw new RuntimeException("在TEST_Operation中发生的未知错误");
            }
        }
        if (!pass) {
            throw new RuntimeException("Operation这个类不行");
        }
    }

    private static void TEST_Info() {
        // 测试简单情况（多了）
        Info simpleInfo = new Info("simpleInfo", 57989, 6);
        if (!"57989".equals(simpleInfo.getValueString()))
            throw new RuntimeException("com.plzEnterCompanyName.HDQS.io.smartIO2.Info无法处理 简单情况（多了）");
        // 测试简单情况（合适）
        simpleInfo.setWidth(5);
        if (!"57989".equals(simpleInfo.getValueString()))
            throw new RuntimeException("com.plzEnterCompanyName.HDQS.io.smartIO2.Info无法处理 简单情况（合适）");
        // 测试简单情况（少了）
        simpleInfo.setWidth(4);
        if (!"5.79e+4".equals(simpleInfo.getValueString()))
            throw new RuntimeException("com.plzEnterCompanyName.HDQS.io.smartIO2.Info无法处理 简单情况（少了）");
        // 测试简单情况（更少）
        simpleInfo.setWidth(3);
        if (!"5.7e+4".equals(simpleInfo.getValueString()))
            throw new RuntimeException("com.plzEnterCompanyName.HDQS.io.smartIO2.Info无法处理 简单情况（更少）");
    }

    static class TestAutoPlay implements Out {

        @Override
        public void out(Message msg) {

        }
    }
}
