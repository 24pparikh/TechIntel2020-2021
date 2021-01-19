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
    static final int MOTOR_TOP_SHOOTER = 4;
    static final int MOTOR_BOTTOM_SHOOTER = 5;
    static final int MOTOR_WOBBLE_ARM = 6;
    static final int MOTOR_INTAKE = 7;

    //********** Servo Indexes **********//
    static final int SERVO_INTAKE = 0;
    static final int SERVO_WOBBLE = 1;


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
    static final float SERVO_GRIPPER_LEFT_REST = .48f;
    static final float SERVO_GRIPPER_LEFT_GRAB = .7f;
    static final float SERVO_GRIPPER_RIGHT_REST = .46f;
    static final float SERVO_GRIPPER_RIGHT_GRAB = .28f;
    static final float SERVO_WOBBLE_FIRST = .35f;
    static final float SERVO_WOBBLE_SECOND = .54f;
    static final float SERVO_WOBBLE_THIRD = .85f;



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