package org.firstinspires.ftc.teamcode.teamcode.supportops;//package org.firstinspires.ftc.teamcode.supportops;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.teamcode.libraries.AutoLib;
//import org.firstinspires.ftc.teamcode.libraries.Constants;
//import org.opencv.core.Point;
//
///*
// * Title: CalcTurn Test
// * Date Created: 2/13/2019
// * Date Modified: 2/22/2019
// * Author: Poorvi
// * Type: Support
// *
// * Description: This will test if the robot can actually turn
// */
//
//@Autonomous(group = "Support")
//public class TestArm extends LinearOpMode {
//    private AutoLib autoLib;
//
//
//    @SuppressWarnings("RedundantThrows")
//    @Override
//    public void runOpMode() throws InterruptedException {
//        initialize();
//        float fastPower = 0.5f;
//        float mediumPower = 0.3f;
//        float slowPower = 0.1f;
//        double distance = 0;
//
//        telemetry.addData("about to move", "initialized");
//        telemetry.update();
////        distance = autoLib.getDistanceCM();
////        telemetry.addData("Distance 1", distance);
////        telemetry.update();
//
////        autoLib.rampMove(250, 1f, Constants.Direction.FORWARD, true);
//        autoLib.rampMove(100, 1f, Constants.Direction.BACKWARD, true);
//        autoLib.rampMove(100, 1f, Constants.Direction.FORWARD, true);
//        autoLib.rampMove(100, 1f, Constants.Direction.RIGHT, true);
//        autoLib.rampMove(100, 1f, Constants.Direction.LEFT, true);
//
////        float armDistance = 10;
////        distance = autoLib.getDistanceCM();
////        telemetry.addData("Distance 2a", distance);
////        telemetry.update();
////        if (distance > armDistance) {
////            autoLib.calcMove((float) distance - armDistance, slowPower, Constants.Direction.RIGHT);
////        } else if (distance < armDistance) {
////            autoLib.calcMove((float) (armDistance - distance), slowPower, Constants.Direction.LEFT);
////        }
////        telemetry.addData("Distance 2b", autoLib.getDistanceCM());
////        telemetry.update();
//
////        Thread.sleep(1000);
////        autoLib.latchServoFoundation();
////        Thread.sleep(1000);
////        autoLib.calcTurn(30, 0.3f);
////        Thread.sleep(1000);
//        //autoLib.restServoFoundation();
//
//    }
//
//
//    private void initialize() {
//        telemetry.addData("Status", "Initializing...");
//        telemetry.update();
//
//        autoLib = new AutoLib(this, new Point[]{new Point(192, 404), new Point(264, 429), new Point(192, 232), new Point(264, 260)});
//        telemetry.update();
//        while (!isStarted()) {
//            telemetry.addData("position", autoLib.getPipeline().getDetectedPosition());
//            telemetry.update();
//        }
//
//        telemetry.addData("Status", "Running");
//        telemetry.update();
//    }
//}
