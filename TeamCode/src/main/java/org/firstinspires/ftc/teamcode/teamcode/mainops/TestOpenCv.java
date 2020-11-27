package org.firstinspires.ftc.teamcode.teamcode.mainops;
//
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.internal.android.dx.ssa.DomFront;
import org.firstinspires.ftc.teamcode.teamcode.libraries.AutoLib;
import org.firstinspires.ftc.teamcode.teamcode.libraries.Constants;
import org.firstinspires.ftc.teamcode.teamcode.libraries.TeleLib;
import org.opencv.core.Point;
//import android.graphics.Point;

/*
 * Title: CalcTurn Test
// * Date Created: 2/13/2019
// * Date Modified: 2/22/2019
// * Author: Poorvi
// * Type: Support
// * Description: This will test if the robot can actually turn
// */
//
@Autonomous(group = "Support")
public class TestOpenCv extends LinearOpMode {
    private AutoLib autoLib;
//private TeleLib teleLib;


    @SuppressWarnings("RedundantThrows")
    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        telemetry.addData("pos", autoLib.getPipeline().getDetectedPosition());
        telemetry.update();
        autoLib.getPipeline().getDetectedPosition();
        Thread.sleep(5000);


    }


    private void initialize() {
        telemetry.addData("Status", "Initializing...");
        telemetry.update();

//        autoLib = new AutoLib(this, new Point[]{new Point(161, 233), new Point(255, 172), new Point(161, 231), new Point(252, 224)});
        autoLib = new AutoLib(this, new Point[]{new Point(413, 243), new Point(187, 146), new Point(413, 307), new Point(187, 290)});
//        teleLib = new TeleLib(this);
        telemetry.addData("Status", "Ready");
        telemetry.update();
        waitForStart();

        telemetry.addData("Status", "Running");
        telemetry.update();
    }
}
