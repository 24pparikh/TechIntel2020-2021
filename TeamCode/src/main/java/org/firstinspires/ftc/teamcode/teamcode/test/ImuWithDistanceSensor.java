package org.firstinspires.ftc.teamcode.teamcode.test;//package org.firstinspires.ftc.teamcode.test;
//
//// Simple autonomous program that drives bot forward until end of period
//// or touch sensor is hit. If touched, backs up a bit and turns 90 degrees
//// right and keeps going. Demonstrates obstacle avoidance and use of the
//// REV Hub's built in IMU in place of a gyro. Also uses gamepad1 buttons to
//// simulate touch sensor press and supports left as well as right turn.
////
//// Also uses IMU to drive in a straight line when not avoiding an obstacle.
//
//import com.qualcomm.hardware.bosch.BNO055IMU;
//import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DistanceSensor;
//import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
//import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
//import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
//import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
//import org.firstinspires.ftc.teamcode.libraries.AutoLib;
//import org.firstinspires.ftc.teamcode.libraries.Constants;
//
//@Autonomous(name="IMU With Distance Sensor", group="Exercises")
////@Disabled
//public class ImuWithDistanceSensor extends LinearOpMode
//{
//    double frontLeftPower;
//    double frontRightPower;
//    double backLeftPower;
//    double backRightPower;
////    TouchSensor             touch;
//    BNO055IMU               imu;
//    Orientation             lastAngles = new Orientation();
//    double                  globalAngle;
//    double correction;
//    double power;
//    boolean                 aButton, bButton, touched;
//    private AutoLib autoLib;
//    private DcMotor frontLeftWheel;
//    private DcMotor frontRightWheel;
//    private DcMotor backLeftWheel;
//    private DcMotor backRightWheel;
//    WebcamName webcamName;
//    private DistanceSensor distanceSensor;
//
//    // called when init button is  pressed.
//    @Override
//    public void runOpMode() throws InterruptedException
//    {
//        initialize();
//
//        power = 0.5;
//        frontLeftWheel = hardwareMap.dcMotor.get("frontLeftWheel");
//        frontRightWheel = hardwareMap.dcMotor.get("frontRightWheel");
//        backLeftWheel = hardwareMap.dcMotor.get("backLeftWheel");
//        backRightWheel = hardwareMap.dcMotor.get("backRightWheel");
//
//        webcamName = hardwareMap.get(WebcamName.class, "Webcam1");
//        DistanceSensor sensorRange = hardwareMap.get(DistanceSensor.class, "frontDistanceSensor");
//        distanceSensor = (Rev2mDistanceSensor)sensorRange;
//
//        frontLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        frontRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        backLeftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        backRightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
//        parameters.mode                = BNO055IMU.SensorMode.IMU;
//        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
//        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//        parameters.loggingEnabled      = false;
//
//        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
//        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
//        // and named "imu".
//        imu = hardwareMap.get(BNO055IMU.class, "imu");
//        imu.initialize(parameters);
//
//        telemetry.addData("Mode", "calibrating...");
//        telemetry.update();
//
//        // make sure the imu gyro is calibrated before continuing.
//        while (!isStopRequested() && !imu.isGyroCalibrated())
//        {
//            sleep(50);
//            idle();
//        }
//
//        telemetry.addData("Mode", "waiting for start");
//        telemetry.addData("imu calib status", imu.getCalibrationStatus().toString());
//
//        telemetry.addData("After Init - 1 imu heading", lastAngles.firstAngle);
//        telemetry.addData("After Init - 2 global heading", globalAngle);
//        telemetry.addData("After Init - 3 correction", correction);
//        telemetry.update();
//
//        resetAngle();
//
//        telemetry.addData("After reset - 1 imu heading", lastAngles.firstAngle);
//        telemetry.addData("After reset - 2 global heading", globalAngle);
//        telemetry.addData("After reset - 3 correction", correction);
//        telemetry.update();
//
//        waitForStart();
//        telemetry.addData("Mode", "running");
//        telemetry.update();
//
//
//
//        sleep(1000);
//
//        // drive until end of period.
//
//        while (opModeIsActive())
//        {
//            // Use gyro to drive in a straight line.
//            correction = checkDirection();
//
//            telemetry.addData("1 imu heading", lastAngles.firstAngle);
//            telemetry.addData("2 global heading", globalAngle);
//            telemetry.addData("3 correction", correction);
//
//            telemetry.addData("deviceName",sensorRange.getDeviceName() );
//            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
//            telemetry.update();
//
//            frontLeftWheel.setPower(power - correction);
//            backRightWheel.setPower(power + correction);
//            frontRightWheel.setPower(power + correction);
//            backLeftWheel.setPower(power - correction);
//
//
//            // We record the sensor values because we will test them in more than
//            // one place with time passing between those places. See the lesson on
//            // Timing Considerations to know why.
//
//            if(distanceSensor.getDistance(DistanceUnit.CM) > 15.0) {
//                frontLeftWheel.setPower(power);
//                frontRightWheel.setPower(power);
//                backLeftWheel.setPower(power);
//                backRightWheel.setPower(power);
//            } else {
//                // stop.
//                frontLeftWheel.setPower(0);
//                frontRightWheel.setPower(0);
//                backLeftWheel.setPower(0);
//                backRightWheel.setPower(0);
//                break;
//
//                // turn 90 degrees right.
//                //if (aButton) rotate(-90, power);
//
//                // turn 90 degrees left.
//                //if (bButton) rotate(90, power);
//            }
//        }
//
//        // turn the motors off.
//        frontRightWheel.setPower(0);
//        frontLeftWheel.setPower(0);
//        backRightWheel.setPower(0);
//        backLeftWheel.setPower(0);
//    }
//
//    /**
//     * Resets the cumulative angle tracking to zero.
//     */
//    private void resetAngle()
//    {
//        lastAngles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
//
//        globalAngle = 0;
//    }
//
//    /**
//     * Get current cumulative angle rotation from last reset.
//     * @return Angle in degrees. + = left, - = right.
//     */
//    private double getAngle()
//    {
//        // We experimentally determined the Z axis is the axis we want to use for heading angle.
//        // We have to process the angle because the imu works in euler angles so the Z axis is
//        // returned as 0 to +180 or 0 to -180 rolling back to -179 or +179 when rotation passes
//        // 180 degrees. We detect this transition and track the total cumulative angle of rotation.
//
//        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
//
//        double deltaAngle = angles.firstAngle - lastAngles.firstAngle;
//
//        if (deltaAngle < -180)
//            deltaAngle += 360;
//        else if (deltaAngle > 180)
//            deltaAngle -= 360;
//
//        globalAngle += deltaAngle;
//
//        lastAngles = angles;
//
//        return globalAngle;
//    }
//
//    /**
//     * See if we are moving in a straight line and if not return a power correction value.
//     * @return Power adjustment, + is adjust left - is adjust right.
//     */
//    private double checkDirection()
//    {
//        // The gain value determines how sensitive the correction is to direction changes.
//        // You will have to experiment with your robot to get small smooth direction changes
//        // to stay on a straight line.
//        double correction, angle, gain = .10;
//
//        angle = getAngle();
//
//        if (angle == 0)
//            correction = 0;             // no adjustment.
//        else
//            correction = -angle;        // reverse sign of angle for correction.
//
//        correction = correction * gain;
//
//        return correction;
//    }
//
//    /**
//     * Rotate left or right the number of degrees. Does not support turning more than 180 degrees.
//     * @param degrees Degrees to turn, + is left - is right
//     */
//    private void rotate(int degrees, double power)
//    {
//        double  frontLeftPower, frontRightPower, backRightPower, backLeftPower ;
//
//        // restart imu movement tracking.
//        resetAngle();
//
//        // getAngle() returns + when rotating counter clockwise (left) and - when rotating
//        // clockwise (right).
//
//        if (degrees < 0)
//        {   // turn right.
//            frontLeftPower = power;
//            backLeftPower = power;
//            frontRightPower = -power;
//            backRightPower = -power;
//        }
//        else if (degrees > 0)
//        {   // turn left.
//            frontLeftPower = -power;
//            backLeftPower = -power;
//            frontRightPower = power;
//            backRightPower = power;
//        }
//        else return;
//
//        // set power to rotate.
//        frontLeftWheel.setPower(frontLeftPower);
//        backLeftWheel.setPower(backLeftPower);
//        frontRightWheel.setPower(frontRightPower);
//        backRightWheel.setPower(backRightPower);
//
//        // rotate until turn is completed.
//        if (degrees < 0)
//        {
//            // On right turn we have to get off zero first.
//            while (opModeIsActive() && getAngle() == 0) {}
//
//            while (opModeIsActive() && getAngle() > degrees) {}
//        }
//        else    // left turn.
//            while (opModeIsActive() && getAngle() < degrees) {}
//
//        // turn the motors off.
//        frontRightWheel.setPower(0);
//        frontLeftWheel.setPower(0);
//        backRightWheel.setPower(0);
//        backLeftWheel.setPower(0);
//
//        // wait for rotation to stop.
//        sleep(1000);
//
//        // reset angle tracking on new heading.
//        resetAngle();
//    }
//
//    private void initialize() {
//        telemetry.addData("Status", "Initializing...");
//        telemetry.update();
//
//        autoLib = new AutoLib(this);
//
//        telemetry.addData("Status", "Ready");
//        telemetry.update();
//        waitForStart();
//
//        telemetry.addData("Status", "Running");
//        telemetry.update();
//    }
//
//}
