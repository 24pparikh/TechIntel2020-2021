//package org.firstinspires.ftc.teamcode.teamcode.supportops;
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
// * Description: This will test if the robot can actually turn
// */
//
//@Autonomous(group = "Park Autonomous Wall Side")
//public class ParkWallSide extends LinearOpMode {
//    private AutoLib autoLib;
//
//
//    @SuppressWarnings("RedundantThrows")
//    @Override
//    public void runOpMode() throws InterruptedException {
//        initialize();
//        telemetry.addData("about to move", "initialized");
//        telemetry.update();
////        Thread.sleep(20000);
//        autoLib.calcMove(25, .1f, Constants.Direction.FORWARD);
//        telemetry.addData("Just moved", "finished moving");
//        telemetry.update();
//    }
//
//
//    private void initialize() {
//        telemetry.addData("Status", "Initializing...");
//        telemetry.update();
//
//        autoLib = new AutoLib(this, new Point[]{new Point(181, 211), new Point(264, 242), new Point(181, 376), new Point(264, 408)});
//        autoLib.grabCapstone();
//
//
//        telemetry.addData("Status", "Ready");
//        telemetry.update();
//        waitForStart();
//
//        telemetry.addData("Status", "Running");
//        telemetry.update();
//    }
//}
