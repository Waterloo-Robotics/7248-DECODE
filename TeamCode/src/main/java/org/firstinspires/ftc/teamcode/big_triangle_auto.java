package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name="big triangle Auto")
public class big_triangle_auto extends LinearOpMode {
    public DcMotor left_drive = null;
    public DcMotor right_drive = null;
    public DcMotor left_2drive = null;
    public DcMotor right_2drive = null;
    public DcMotor flywheel = null;
    public DcMotor intake = null;
    public DcMotor tran_DcMotor1 = null;
    public DcMotor tran_DcMotor2 = null;
    public GoBildaPinpointDriver ppointdr= null;

    private ElapsedTime runtime = new ElapsedTime();

    // we use a varible so we can change the power easily later on
    static final double FORWARD_POWER = 0.1;
    static final long DRIVE_TIME_MS = 2800;




    @Override
    public void runOpMode() {
        left_drive = hardwareMap.get(DcMotor.class, "left_drive");
        right_drive = hardwareMap.get(DcMotor.class, "right_drive");
        left_2drive = hardwareMap.get(DcMotor.class, "left_2drive");
        right_2drive = hardwareMap.get(DcMotor.class, "right_2drive");
        flywheel = hardwareMap.get(DcMotor.class, "shooter");
        intake = hardwareMap.get(DcMotor.class, "intake");
        tran_DcMotor1 = hardwareMap.get(DcMotor.class, "tran_DcMotor1");
        tran_DcMotor2 = hardwareMap.get(DcMotor.class, "tran_DcMotor2");
        left_drive.setDirection(DcMotor.Direction.FORWARD);
        right_drive.setDirection(DcMotor.Direction.REVERSE);
        left_2drive.setDirection(DcMotor.Direction.FORWARD);
        right_2drive.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        if (opModeIsActive()) {

            // SLEEP = Time to run command before moving to the next, in miliseconds
            sleep(750);
            left_drive.setPower(.7);
            right_drive.setPower(.7);
            left_2drive.setPower(.7);
            right_2drive.setPower(.7);
            sleep(300);
            left_drive.setPower(0);
            right_drive.setPower(0);
            left_2drive.setPower(0);
            right_2drive.setPower(0);
            flywheel.setPower(.6);
            sleep(2000);
            tran_DcMotor2.setPower(1);
            sleep(2000);
            tran_DcMotor1.setPower(-1);
            sleep(2000);
            intake.setPower(1);
            sleep(1000);
            tran_DcMotor1.setPower(0);
            tran_DcMotor2.setPower(0);
            flywheel.setPower(0);
            intake.setPower(0);
        }

    }}