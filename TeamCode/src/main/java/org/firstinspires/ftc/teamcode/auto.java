package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name="Leave Auto")
public class auto extends LinearOpMode {
    public DcMotor left_drive = null;
    public DcMotor right_drive = null;
    public DcMotor left_2drive = null;
    public DcMotor right_2drive = null;
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
        left_drive.setDirection(DcMotor.Direction.FORWARD);
        right_drive.setDirection(DcMotor.Direction.REVERSE);
        left_2drive.setDirection(DcMotor.Direction.FORWARD);
        right_2drive.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        if (opModeIsActive()) {

            // SLEEP = Time to run command before moving to the next, in miliseconds
            sleep(750);
            left_drive.setPower(-0.5);
            right_drive.setPower(-0.5);
            left_2drive.setPower(-0.5);
            right_2drive.setPower(-0.5);
            sleep(800);
        }

    }}