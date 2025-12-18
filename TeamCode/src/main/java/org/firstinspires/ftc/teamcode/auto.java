package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name="Auto")
public class auto extends LinearOpMode {
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public GoBildaPinpointDriver ppointdr= null;

    private ElapsedTime runtime = new ElapsedTime();

    static final double FORWARD_POWER = 0.5;
    static final long DRIVE_TIME_MS = 2800;



    @Override
    public void runOpMode() {
    frontLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    frontRightMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    backLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    backRightMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
    ppointdr= hardwareMap.get(GoBildaPinpointDriver.class, "ppdriver");

    ppointdr.setOffsets(-175, 115, DistanceUnit.MM);
    ppointdr.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.REVERSED, GoBildaPinpointDriver.EncoderDirection.FORWARD);



    frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
    frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
    backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
    backRightMotor.setDirection(DcMotor.Direction.REVERSE);



    waitForStart();

    while (opModeIsActive()) {
//        backLeftMotor.setPower(FORWARD_POWER);
//        backRightMotor.setPower(FORWARD_POWER);
//        frontLeftMotor.setPower(FORWARD_POWER);
//        frontRightMotor.setPower(FORWARD_POWER);



        telemetry.addData("Position X", "%f.2",
                telemetry.addData("Position Y", "%f.2",
                telemetry.addData("Position", "%f.2",
    }
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
}


}
