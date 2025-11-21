package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto")
public class auto extends LinearOpMode {
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    private ElapsedTime runtime = new ElapsedTime();

    static final double FORWARD_POWER = 0.5;
    static final long DRIVE_TIME_MS = 2800;



    @Override
    public void runOpMode() {
    frontLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    frontRightMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    backLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    backRightMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");

    frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
    frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
    backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
    backRightMotor.setDirection(DcMotor.Direction.REVERSE);



    waitForStart();

    while (opModeIsActive() && runtime.milliseconds() < DRIVE_TIME_MS) {
        backLeftMotor.setPower(FORWARD_POWER);
        backRightMotor.setPower(FORWARD_POWER);
        frontLeftMotor.setPower(FORWARD_POWER);
        frontRightMotor.setPower(FORWARD_POWER);

    }
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
}


}
