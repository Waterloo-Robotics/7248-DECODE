package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class shooterTeleop extends OpMode {

    // declare motors. "motor" is a placeholder. rename to flywheel, or other desired motor names
    // in the future. be sure to also modify the hardware map on ds - kyeler
    private DcMotor motor; // flywheel motor

   // this code runs in initialize, typically used to set motor power and grab motors, servos, and
    // any other hardware from the hardware map
@Override
    public void init() {
    motor = hardwareMap.get(DcMotor.class, "motor");
}

@Override
    public void start() {

}

@Override
    public void loop() {

    // 1/4 total power
    if (gamepad1.dpad_left) {
        motor.setPower(0.25);
    }
    // half total power
    if (gamepad1.dpad_up) {
        motor.setPower(0.5);
    }
    // 3/4 total power
    if (gamepad1.dpad_right) {
        motor.setPower(0.75);
    }
    // full power
    if (gamepad1.dpad_right) {
        motor.setPower(1);
    }
    // deactivate motor
    if (gamepad1.rightBumperWasPressed()) {
        motor.setPower(0);
    }
}
}
