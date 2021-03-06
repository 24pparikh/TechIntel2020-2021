package org.firstinspires.ftc.teamcode.teamcode.libraries;//package org.firstinspires.ftc.teamcode.libraries;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//import org.firstinspires.ftc.robotcore.external.ClassFactory;
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
//import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
//import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
//import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
//import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
//import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
//import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;
//import static org.firstinspires.ftc.teamcode.libraries.Constants.VUFORIA_KEY;
//
//@Autonomous(name = "Blue Autonomous", group = "Concept")
//
//public class ConceptVuforiaSkyStoneNavigationWebcam2 extends LinearOpMode {
//
//    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
//    private static final boolean PHONE_IS_PORTRAIT = false;
//
//
//    private static final String VUFORIA_KEY = "ARSzhHP/////AAABmQ3dyIKKfkcipjZh0HtnoDEkjuCn18CTNUWRN7PTFoedxZLS+QZmpkyXpQnQXFpQ5ol//l0ZwTejVrGRQ4i/kQBrrFJ8E0C7ckr4lzf5bLCvi1/E9x8anPwt2D0UToZ3MB5jPx4T6s/EOs575BtxjL7uv5jrCbQDsXebm2PROU4zC/Dj7+AYFkKCqD3YYLbGPGV4YoSgp9Ihoe+ZF/eae0FLG8K/o4eyfZj0B3aXkRvYi3dC5LY+c76aU72bKTrQ2PDYSxDG8xCaY1JyEyfDA6XqjHjYMvh0BBbb8bAQvPgG6/G50+5L+c/a8u6sbYJLbvVtXdMtrG1EA4CglbnsDs7GyyJmH5AusSwIDb9DQnTA";
//
//
//    // Since ImageTarget trackables use mm to specifiy their dimensions, we must use mm for all the physical dimension.
//    // We will define some constants and conversions here
//    private static final float mmPerInch = 25.4f;
//    private static final float mmTargetHeight = (6) * mmPerInch;          // the height of the center of the target image above the floor
//
//    // Constant for Stone Target
//    private static final float stoneZ = 2.00f * mmPerInch;
//
//    // Constants for the center support targets
//    private static final float bridgeZ = 6.42f * mmPerInch;
//    private static final float bridgeY = 23 * mmPerInch;
//    private static final float bridgeX = 5.18f * mmPerInch;
//    private static final float bridgeRotY = 59;                                 // Units are degrees
//    private static final float bridgeRotZ = 180;
//
//    // Constants for perimeter targets
//    private static final float halfField = 72 * mmPerInch;
//    private static final float quadField = 36 * mmPerInch;
//
//    String positionSkystone = "";
//    double yPosition = 0;
//    double xPosition = 0;
//    boolean startIdentify = true;
//    float distanceToDepot = 200;    //115
//    float distanceToCenterLine = 5.5f;
//    float forwardDistanceSkystone = 28f;
//    float turningDegree = -80;
//    float foundation = 35;
//
//    // Class Members
//    private OpenGLMatrix lastLocation = null;
//    private VuforiaLocalizer vuforia = null;
//
//
//    WebcamName webcamName = null;
//
//    private boolean targetVisible = false;
//    private float phoneXRotate = 0;
//    private float phoneYRotate = 0;
//    private float phoneZRotate = 0;
//    private AutoLib autoLib;
//
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        initialize();
//
//        /*
//         * Retrieve the camera we are to use.
//         */
//
//
//        webcamName = hardwareMap.get(WebcamName.class, "Webcam1");
//
//
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
//
//        parameters.vuforiaLicenseKey = VUFORIA_KEY;
//
//        parameters.cameraName = webcamName;
//
//        vuforia = ClassFactory.getInstance().createVuforia(parameters);
//
//        VuforiaTrackables targetsSkyStone = this.vuforia.loadTrackablesFromAsset("Skystone");
//
//        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);
//        stoneTarget.setName("Stone Target");
//        VuforiaTrackable blueRearBridge = targetsSkyStone.get(1);
//        blueRearBridge.setName("Blue Rear Bridge");
//        VuforiaTrackable redRearBridge = targetsSkyStone.get(2);
//        redRearBridge.setName("Red Rear Bridge");
//        VuforiaTrackable redFrontBridge = targetsSkyStone.get(3);
//        redFrontBridge.setName("Red Front Bridge");
//        VuforiaTrackable blueFrontBridge = targetsSkyStone.get(4);
//        blueFrontBridge.setName("Blue Front Bridge");
//        VuforiaTrackable red1 = targetsSkyStone.get(5);
//        red1.setName("Red Perimeter 1");
//        VuforiaTrackable red2 = targetsSkyStone.get(6);
//        red2.setName("Red Perimeter 2");
//        VuforiaTrackable front1 = targetsSkyStone.get(7);
//        front1.setName("Front Perimeter 1");
//        VuforiaTrackable front2 = targetsSkyStone.get(8);
//        front2.setName("Front Perimeter 2");
//        VuforiaTrackable blue1 = targetsSkyStone.get(9);
//        blue1.setName("Blue Perimeter 1");
//        VuforiaTrackable blue2 = targetsSkyStone.get(10);
//        blue2.setName("Blue Perimeter 2");
//        VuforiaTrackable rear1 = targetsSkyStone.get(11);
//        rear1.setName("Rear Perimeter 1");
//        VuforiaTrackable rear2 = targetsSkyStone.get(12);
//        rear2.setName("Rear Perimeter 2");
//
//        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();
//        allTrackables.addAll(targetsSkyStone);
//
//        stoneTarget.setLocation(OpenGLMatrix
//                .translation(0, 0, stoneZ)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));
//
//        blueFrontBridge.setLocation(OpenGLMatrix
//                .translation(-bridgeX, bridgeY, bridgeZ)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, bridgeRotZ)));
//
//        blueRearBridge.setLocation(OpenGLMatrix
//                .translation(-bridgeX, bridgeY, bridgeZ)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, bridgeRotZ)));
//
//        redFrontBridge.setLocation(OpenGLMatrix
//                .translation(-bridgeX, -bridgeY, bridgeZ)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, 0)));
//
//        redRearBridge.setLocation(OpenGLMatrix
//                .translation(bridgeX, -bridgeY, bridgeZ)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, 0)));
//
//        //Set the position of the perimeter targets with relation to origin (center of field)
//        red1.setLocation(OpenGLMatrix
//                .translation(quadField, -halfField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));
//
//        red2.setLocation(OpenGLMatrix
//                .translation(-quadField, -halfField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));
//
//        front1.setLocation(OpenGLMatrix
//                .translation(-halfField, -quadField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));
//
//        front2.setLocation(OpenGLMatrix
//                .translation(-halfField, quadField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));
//
//        blue1.setLocation(OpenGLMatrix
//                .translation(-quadField, halfField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));
//
//        blue2.setLocation(OpenGLMatrix
//                .translation(quadField, halfField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));
//
//        rear1.setLocation(OpenGLMatrix
//                .translation(halfField, quadField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));
//
//        rear2.setLocation(OpenGLMatrix
//                .translation(halfField, -quadField, mmTargetHeight)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));
//
//
//        if (CAMERA_CHOICE == BACK) {
//            phoneYRotate = -90;
//        } else {
//            phoneYRotate = 90;
//        }
//
//        if (PHONE_IS_PORTRAIT) {
//            phoneXRotate = 90;
//        }
//
//        final float CAMERA_FORWARD_DISPLACEMENT = 4.0f * mmPerInch;   // eg: Camera is 4 Inches in front of robot-center
//        final float CAMERA_VERTICAL_DISPLACEMENT = 8.0f * mmPerInch;   // eg: Camera is 8 Inches above ground
//        final float CAMERA_LEFT_DISPLACEMENT = 0;     // eg: Camera is ON the robot's center line
//
//        OpenGLMatrix robotFromCamera = OpenGLMatrix
//                .translation(CAMERA_FORWARD_DISPLACEMENT, CAMERA_LEFT_DISPLACEMENT, CAMERA_VERTICAL_DISPLACEMENT)
//                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, YZX, DEGREES, phoneYRotate, phoneZRotate, phoneXRotate));
//
//        for (VuforiaTrackable trackable : allTrackables) {
//            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(robotFromCamera, parameters.cameraDirection);
//        }
//
//        targetsSkyStone.activate();
//        if (startIdentify) {
//            autoLib.calcMove(50, .8f, Constants.Direction.RIGHT);    //46
//            Thread.sleep(1000);
//            while (!isStopRequested() && startIdentify) {
//
//                targetVisible = false;
//                for (VuforiaTrackable trackable : allTrackables) {
//                    if (((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {
//                        telemetry.addData("Visible Target", trackable.getName());
//                        targetVisible = true;
//
//                        OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener) trackable.getListener()).getUpdatedRobotLocation();
//                        if (robotLocationTransform != null) {
//                            lastLocation = robotLocationTransform;
//                        }
//                        break;
//                    }
//                }
//
////            String positionSkystone = "";
////            double yPosition = 0;
////            double xPosition = 0;
//                if (targetVisible) {
//                    // express position (translation) of robot in inches.
//                    VectorF translation = lastLocation.getTranslation();
//                    telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",
//                            translation.get(0) / mmPerInch, translation.get(1) / mmPerInch, translation.get(2) / mmPerInch);
//
//                    yPosition = translation.get(1);
//                    xPosition = translation.get(0);
//                    if (yPosition <= 0) {
//                        positionSkystone = "Left";
////                        autoLib.calcMove(1, .7f, Constants.Direction.LEFT);
//                        distanceToDepot = distanceToDepot - 10;
//                        finalMoveLeft(-xPosition, yPosition);
//                        // distanceToDepot = distanceToCenterLine + 6;
//                    } else {
//                        positionSkystone = "Center";
//                        //if (xPosition <= -25) {
//                        distanceToDepot = distanceToDepot + 15; //20
//                       /* forwardDistanceSkystone = forwardDistanceSkystone + 3;
//                        distanceToCenterLine = distanceToCenterLine + 1;
//                        turningDegree = turningDegree - 1f;
//                        foundation = foundation + 4;
//                        turningDegree = turningDegree - 1;*/
////                        turningDegree = turningDegree - 10f;
//                        sleep(750);
//                        yPosition = translation.get(1);
//                        xPosition = translation.get(0);
//                        finalMoveCenter(-xPosition, yPosition);
//                        break;
////                        } else {
////                            telemetry.addData("Final Position Reached", "none");
////                        }
//                    }
//
//                    // express the rotation of the robot in degrees.
//                    Orientation rotation = Orientation.getOrientation(lastLocation, EXTRINSIC, XYZ, DEGREES);
//                    telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);
//                } else {
//                    positionSkystone = "Right";
//                    telemetry.addData("Visible Target", "none");
//
//                    distanceToDepot = distanceToDepot + 40;
//                    /*distanceToCenterLine = distanceToCenterLine + 1;
//                    forwardDistanceSkystone = forwardDistanceSkystone - 1;
//                    foundation = foundation - 3;*/
//                    finalMoveRight(-xPosition, yPosition);
//                    //autoLib.calcMove(20, .7f, Constants.Direction.RIGHT);
//                    Thread.sleep(1000);
//
//                }
//                telemetry.addData("Skystone Position", positionSkystone);
//                telemetry.update();
//            }
//        }
//
//        targetsSkyStone.deactivate();
//    }
//
//    private void finalMoveCenter(double xPosition, double yPosition) throws InterruptedException {
//        telemetry.addData("Final Position Reached", "none");
//        telemetry.addData("X Position ", xPosition);
//        telemetry.addData("Y Position ", yPosition);
//// go near skystone
//
//        autoLib.autonArmDown();
//
//        autoLib.calcMove(8, .6f, Constants.Direction.FORWARD); //when decreased- moves to the left
//        autoLib.calcMove(22, .3f, Constants.Direction.RIGHT);   //when increased-moves back
////        distanceToDepot = distanceToDepot + (float) yPosition + 5;
//        autoLib.calcMove(7.5f, .2f, Constants.Direction.RIGHT);
//        Thread.sleep(500);
//        autoLib.autonGrab();
//        Thread.sleep(500);
//        autoLib.calcMove(20, .8f, Constants.Direction.LEFT);    //16
//        autoLib.calcMove(220, 1f, Constants.Direction.FORWARD);    //distanceToDepot
//        autoLib.calcMove(18, .7f, Constants.Direction.RIGHT);        //Foundation
//        autoLib.autonScore();
//        autoLib.calcTurn(-90,.5f);
//        Thread.sleep(300);
//        autoLib.latchServoFoundation();
//        autoLib.calcMove(10, .15f, Constants.Direction.BACKWARD);
//        autoLib.calcMove(108, 1f, Constants.Direction.FORWARD);
//        autoLib.restServoFoundation();
//        autoLib.calcMove(132, 1f, Constants.Direction.LEFT);
//
//        startIdentify = false;
//
//    }
//
//    private void finalMoveLeft(double xPosition, double yPosition) throws InterruptedException {
//        telemetry.addData("Final Position Reached", "none");
//        telemetry.addData("X Position ", xPosition);
//        telemetry.addData("Y Position ", yPosition);
//// go near skystone
//        //autoLib.moveArmDownScoreServoArmGrab();
//
//        autoLib.calcMove(13, .9f, Constants.Direction.LEFT); //15
//        autoLib.calcMove(22, .5f, Constants.Direction.BACKWARD);   //when increased-moves back
////        distanceToDepot = distanceToDepot + (float) yPosition + 5;
////        autoLib.calcMove(10f, .7f, Constants.Direction.BACKWARD);
//        autoLib.calcMove(7.5f, .2f, Constants.Direction.BACKWARD);
//        Thread.sleep(300);
//        autoLib.armGrab();
//        Thread.sleep(500);
//        autoLib.calcMove(22, 1f, Constants.Direction.FORWARD);    //16
//        autoLib.calcTurn(-74, .7f); //53
//
//        autoLib.calcMove(199, 1f, Constants.Direction.BACKWARD);
//        autoLib.calcTurn(78, .6f);
//        autoLib.calcMove(19, .7f, Constants.Direction.BACKWARD);
//        autoLib.calcMove(12, .25f, Constants.Direction.BACKWARD);
//        Thread.sleep(300);
//        autoLib.latchServoFoundation();
//        Thread.sleep(1000);
//        autoLib.calcMove(107, 1f, Constants.Direction.FORWARD);
//        autoLib.restServoFoundation();
//        autoLib.calcMove(126, 1f, Constants.Direction.RIGHT);
//        startIdentify = false;
//
//    }
//
//    private void finalMoveRight(double xPosition, double yPosition) throws InterruptedException {
//        telemetry.addData("Final Position Reached", "none");
//        telemetry.addData("X Position ", xPosition);
//        telemetry.addData("Y Position ", yPosition);
//// go near skystone
//        //autoLib.moveArmDownScoreServoArmGrab();
//
//        autoLib.calcMove(30, .5f, Constants.Direction.RIGHT); //when decreased- moves to the left
//        autoLib.calcMove(20, .5f, Constants.Direction.BACKWARD);   //when increased-moves back
////        distanceToDepot = distanceToDepot + (float) yPosition + 5;
//        autoLib.calcMove(7.5f, .2f, Constants.Direction.BACKWARD);
//        Thread.sleep(500);
//        autoLib.armGrab();
//        Thread.sleep(500);
//        autoLib.calcMove(22, .8f, Constants.Direction.FORWARD);    //16
//        autoLib.calcTurn(-75, .7f); //53
//        autoLib.calcMove(240, 1f, Constants.Direction.BACKWARD);
//        autoLib.calcTurn(75, .6f);
//        autoLib.calcMove(20, .45f, Constants.Direction.BACKWARD);
//        autoLib.calcMove(8, .15f, Constants.Direction.BACKWARD);
//        Thread.sleep(300);
//        autoLib.latchServoFoundation();
//        Thread.sleep(1000);
//        autoLib.calcMove(104, 1f, Constants.Direction.FORWARD);
//        autoLib.restServoFoundation();
//        autoLib.calcMove(127, 1f, Constants.Direction.RIGHT);
//        startIdentify = false;
//
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
//}
