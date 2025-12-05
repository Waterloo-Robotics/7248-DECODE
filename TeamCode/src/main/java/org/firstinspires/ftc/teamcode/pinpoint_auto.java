package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Pinpoint Auto")
public class pinpoint_auto extends LinearOpMode {
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public GoBildaPinpointDriver pinpoint = null;
    private ElapsedTime runtime = new ElapsedTime();



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

    while (opModeIsActive()) {


    }
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
}


}
