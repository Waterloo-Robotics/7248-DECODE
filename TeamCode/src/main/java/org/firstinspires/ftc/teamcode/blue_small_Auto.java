package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="blue small Auto")
public class blue_small_Auto extends LinearOpMode {
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
            left_drive.setPower(-.4);
            right_drive.setPower(-.4);
            left_2drive.setPower(-.4);
            right_2drive.setPower(-.4);
            sleep(3900);
            left_drive.setPower(.4);
            right_drive.setPower(-.4);
            left_2drive.setPower(.4);
            right_2drive.setPower(-.4);
            sleep(600);
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
            //new
            left_drive.setPower(.3);
            right_drive.setPower(-.3);
            left_2drive.setPower(.3);
            right_2drive.setPower(-.3);
            sleep(450);
            left_drive.setPower(.35);
            right_drive.setPower(-.35);
            left_2drive.setPower(-.35);
            right_2drive.setPower(.35);
            sleep(350);
            tran_DcMotor2.setPower(1);
            tran_DcMotor1.setPower(-1);
            intake.setPower(1);
            sleep(1000);
            left_drive.setPower(-.3);
            right_drive.setPower(-.3);
            left_2drive.setPower(-.3);
            right_2drive.setPower(-.3);
            sleep(2300);
            tran_DcMotor2.setPower(0);
            tran_DcMotor1.setPower(0);
            sleep(1000);
            intake.setPower(0);
        }

    }}