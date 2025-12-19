/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.vision.opencv.PredominantColorProcessor;

import java.util.Objects;

/*
 * This OpMode executes a Tank Drive control TeleOp a direct drive robot
 * The code is structured as an Iterative OpMode
 *
 * In this mode, the left and right joysticks control the left and right motors respectively.
 * Pushing a joystick forward will make the attached motor drive forward.
 * It raises and lowers the claw using the Gamepad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="Sea of Electrons", group="Robot")
public class OurTeleop extends OpMode{
    /* Declare OpMode members. */
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public Servo intake = null;
    public DcMotorEx flywheel = null;
    public Servo transfer_servo = null;
    public DcMotor transfer_motor = null;
    private boolean flywheelon;

    String savedColorMatch = null;



    double desired_speed_rpm;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        // Define and Initialize Motors
        frontLeftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        frontRightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        backLeftMotor = hardwareMap.get(DcMotor.class, "left_2drive");
        backRightMotor = hardwareMap.get(DcMotor.class, "right_2drive");
        intake = hardwareMap.get(Servo.class, "intake");
        flywheel = hardwareMap.get(DcMotorEx.class, "shooter");
        transfer_servo = hardwareMap.get(Servo.class,"tran_servo");
        transfer_motor = hardwareMap.get(DcMotorEx.class,"tran_motor");


        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left and right sticks forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        backRightMotor.setDirection(DcMotor.Direction.REVERSE);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        // leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // Send telemetry message to signify robot waiting;
        telemetry.addData(">", "Robot Ready.  Press START.");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit START
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits START
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits START but before they hit STOP
     */
    @Override
    public void loop() {

        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x * .8; // Counteract imperfect strafing
        double rx = - gamepad1.right_stick_x * .25;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), .1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        setSafePower(frontLeftMotor, frontLeftPower);
        setSafePower(backLeftMotor, backLeftPower);
        setSafePower(frontRightMotor, frontRightPower);
        setSafePower(backRightMotor, backRightPower);


//        PredominantColorProcessor.Result result = null;
//        if (result.closestSwatch == PredominantColorProcessor.Swatch.RED) {{
//            intake.setPosition(.5);
//        }
//            savedColorMatch = "RED";
//            // your code here: optional to exit the vision loop based on your criteria
//            // your code here: robot actions if the ROI was RED
//            Color.red(result.rgb);
//
//
//        }


// After exiting the vision loop...
//        servo values: forward=1 stop=0 reverse=-1
        if (gamepad2.aWasPressed())
        {
            intake.setPosition(0);
        }
        if (gamepad2.bWasPressed()) {
            intake.setPosition(.5);
        }
       if (gamepad2.yWasPressed()) {
            intake.setPosition(1);
        }

        if (gamepad2.right_trigger >.1) {
            transfer_servo.setPosition(0);
        }
        else if (gamepad2.left_trigger >.1) {
            transfer_motor.setPower(1);
        }

        else {transfer_servo.setPosition(.5);
            }
        if (gamepad2.right_bumper) {
            transfer_servo.setPosition(1);
        }
        else if (gamepad2.left_bumper) {
            transfer_motor.setPower(-1);
        }

        else {transfer_motor.setPower(0);
        }









        // Get current motor speed in revolutions per minute (RPM)
//        double wheel_speed_deg_p_sec = flywheel.getVelocity();
        double wheel_speed_deg_p_sec = flywheel.getVelocity();
        double wheel_rpm = (wheel_speed_deg_p_sec / 28) * 60;

        // Tell it what speed we want it to go
        // desired_speed_rpm += -gamepad2.left_stick_y ;


        if(flywheelon){
            desired_speed_rpm = 3100;
        }
        if (gamepad2.leftStickButtonWasPressed()) {
            flywheelon = !flywheelon;
        }
        else {
            desired_speed_rpm = 0;
        }


        // Convert the desired speed to a motor power
        double motor_power = (desired_speed_rpm) / 4100; //assume 4100 max speed of the motor due to system load.

        // How far away are we from our desired speed
        double error = desired_speed_rpm - wheel_rpm;
//        double extra_power = error * 0.0002;
        double extra_power = 0; //set to 0 for now until we complete troubleshooting wheel_rpm issue

        flywheel.setPower(motor_power + extra_power);

        /* ---------------- GENERAL TELEMETRY ---------------- */
        telemetry.addData("Desired Speed", desired_speed_rpm);
        telemetry.addData("Speed Error", error);
        telemetry.addData("Wheel velocity tick", wheel_speed_deg_p_sec);




    }



    void setSafePower(DcMotor motor, double targetPower) {
        final double SLEW_RATE = 0.2;
        double currentPower = motor.getPower();
        double desiredChange = targetPower - currentPower;
        double limitedChange = Math.max(-SLEW_RATE, Math.min(desiredChange, SLEW_RATE));
        motor.setPower(currentPower += limitedChange);

    }
}
