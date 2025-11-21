package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "shooterTeleop", group = "Concept")
public class shooterprototypeTeleop extends OpMode {
    private DcMotor motor; // flywheel motor
    private int motor_speed = 0; // 0 = off, 1-4 = power levels
    private boolean prevRightBumper = false;
    private boolean prevLeftBumper = false;

    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "flywheel");
    }

    @Override
    public void loop() {
        boolean rightBumperPressed = gamepad1.right_bumper;
        boolean leftBumperPressed = gamepad1.left_bumper;

        // Right bumper: increase speed
        if (rightBumperPressed && !prevRightBumper) {
            if (motor_speed < 4) {
                motor_speed++;
            }
        }

        if (leftBumperPressed && !prevLeftBumper) {
            motor_speed = 0;
        }

        double power = 0.0;
        switch (motor_speed) {
            case 1:
                power = 0.25;
                break;
            case 2:
                power = 0.5;
                break;
            case 3:
                power = 0.75;
                break;
            case 4:
                power = 1.0;
                break;
            default:
                power = 0.0;
                break;
        }
        motor.setPower(power);

        // Telemetry feedback
        telemetry.addData("Motor Speed Level", motor_speed);
        telemetry.update();

        // Store previous button states
        prevRightBumper = rightBumperPressed;
        prevLeftBumper = leftBumperPressed;
    }
}
