package org.firstinspires.ftc.teamcode.teamcode.libraries;

/*
 * Title: Constants
 * Date Created: 10/14/2018
 * Date Modified: 2/27/2019
 * Author: Poorvi, Sachin
 * Type: Library
 * Description: This will contain all of the constants we will use in any of our programs.
 */

public class Constants {

    //********** Gamepad Tolerance Constants **********//
    static final float GAMEPAD_JOYSTICK_TOLERANCE = .05f;
    static final float GAMEPAD_TRIGGER_TOLERANCE = .05f;

    //********** DcMotor Indexes **********//
    static final int MOTOR_FRONT_LEFT_WHEEL = 0;
    static final int MOTOR_FRONT_RIGHT_WHEEL = 1;
    static final int MOTOR_BACK_LEFT_WHEEL = 2;
    static final int MOTOR_BACK_RIGHT_WHEEL = 3;
    static final int MOTOR_RIGHT_INTAKE = 4;
    static final int MOTOR_LEFT_INTAKE = 5;
    static final int MOTOR_ARM = 6;
    static final int MOTOR_TAPE = 7;

    //********** Servo Indexes **********//
    static final int SERVO_CAPSTONE = 0;
    static final int SERVO_GRABBER = 1;
    static final int SERVO_FOUNDATION1 = 2;
    static final int SERVO_FOUNDATION2 = 3;
    static final int SERVO_SCORING_ARM = 4;
    static final int SERVO_AUTONOMOUS_GRABBER = 5;
    static final int SERVO_AUTONOMOUS_ARM = 6;
    static final int SERVO_INTAKE = 7;
    static final int SERVO_STOPPER = 8;
    static final int SERVO_AUTONOMOUS_GRABBER_FRONT = 9;


    //********** Ramp *********************//
    final static float MOTOR_RAMP_FB_POWER_LOWER_LIMIT = 0.35f;  //.3
    final static float MOTOR_RAMP_FB_POWER_UPPER_LIMIT = 1f; //.78
    final static float MOTOR_RAMP_SIDEWAYS_POWER_LOWER_LIMIT = 0.1f;    //.6
    final static float MOTOR_RAMP_SIDEWAYS_POWER_UPPER_LIMIT = 1f;   //.78
    final static float MAX_ROBOT_TURN_MOTOR_VELOCITY = 0.78f;
    final static float MIN_ROBOT_TURN_MOTOR_VELOCITY = 0.15f;
    final static float LEFT_MOTOR_TRIM_FACTOR = .8f;
    final static float RIGHT_MOTOR_TRIM_FACTOR = .8f;
    final static float MOTOR_LOWER_POWER_THRESHOLD = 0.15f;
    final static int MAX_MOTOR_LOOP_TIME = 10000;     //max time to wait in a tight loop
    final static int ENCODED_MOTOR_STALL_TIME_DELTA = 200; //time to wait in stall check code
    final static float MECANUM_WHEEL_ENCODER_MARGIN = 50;


    //********** Servo Positions **********//
    static final float SERVO_ARM_POS_RECIEVE = .97f;
    static final float SERVO_ARM_POS_SCORE = .27f;
    static final float SERVO_GRABBER_GRAB = 0.60f;
    static final float SERVO_CAPSTONE_DROP = .2f;
    static final float SERVO_CAPSTONE_HOLD = 0.46f;
    static final float SERVO_GRABBER_REST = .36f;
    static final float SERVO_FOUNDATION_GRAB1 = .56f;
    static final float SERVO_FOUNDATION_REST1 = .78f;   //.67
    static final float SERVO_FOUNDATION_GRAB2 = .73f;    //.8
    static final float SERVO_FOUNDATION_REST2 = .46f;   //.59
    static final float SERVO_AUTONOMOUS_GRABBER_GRAB = .7f;
    static final float SERVO_AUTONOMOUS_GRABBER_SCORE = .28f;
    static final float SERVO_AUTONOMOUS_GRABBER_FRONT_GRAB = .7f;
    static final float SERVO_AUTONOMOUS_GRABBER_FRONT_SCORE = .7f;
    static final float SERVO_AUTONOMOUS_UP_ARM = .55f;   //.4
    static final float SERVO_AUTONOMOUS_DOWN_ARM = 1f;
    static final float SERVO_SCORING_EXTEND = 0.12f; // Change position
    static final float SERVO_SCORING_RETRACT = 0.9f;// Change position
    static final float SERVO_TELEOP_ARM_POSITION = .15f;
    static final float SERVO_STOPPER_STOP = 0.57f;
    static final float SERVO_STOPPER_REST = 0f;

    //********** Touch Sensor Indexes **********//
    public static final int FOUNDATION_TOUCH_SENSOR = 0;

    //********** CalcMove Constants **********//
    static final float WHEEL_DIAMETER = 9.5f;
    static final float WHEEL_GEAR_RATIO = (1f / 1);
    static final float NEVEREST_40_REVOLUTION_ENCODER_COUNT = 383.6f;    //694.75 - 383.6
    static final float TRACK_DISTANCE = 36f;
    static final float BRAKE_POINT = 6;

    public enum Direction {FORWARD, BACKWARD, LEFT, RIGHT}


    //********** TensorFlow **********//

    static final String VUFORIA_KEY = "ARSzhHP/////AAABmQ3dyIKKfkcipjZh0HtnoDEkjuCn18CTNUWRN7PTFoedxZLS+QZmpkyXpQnQXFpQ5ol//l0ZwTejVrGRQ4i/kQBrrFJ8E0C7ckr4lzf5bLCvi1/E9x8anPwt2D0UToZ3MB5jPx4T6s/EOs575BtxjL7uv5jrCbQDsXebm2PROU4zC/Dj7+AYFkKCqD3YYLbGPGV4YoSgp9Ihoe+ZF/eae0FLG8K/o4eyfZj0B3aXkRvYi3dC5LY+c76aU72bKTrQ2PDYSxDG8xCaY1JyEyfDA6XqjHjYMvh0BBbb8bAQvPgG6/G50+5L+c/a8u6sbYJLbvVtXdMtrG1EA4CglbnsDs7GyyJmH5AusSwIDb9DQnTA";

    static final Object Coordinates = new Object();

    static final float VUFORIA_READING_TIME = 2f;

    public static class Coordinates {
        public double xPosition;
        public double yPosition;

        public Coordinates(double xPosition, double yPosition) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }
    }
}