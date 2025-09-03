package hotel.management.system.util;

import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DigitListner implements DocumentListener {

    JTextField famountp, fpamount, feamount, roomPrice;
    JLabel errorMsg, originalDAmt, originalPAmt;

    public DigitListner(JTextField famountp, JTextField fpamount, JTextField feamount,
            JTextField roomPrice, JLabel errorMsg, JLabel originalDAmt, JLabel originalPAmt) {
        this.famountp = famountp;
        this.fpamount = fpamount;
        this.feamount = feamount;
        this.roomPrice = roomPrice;
        this.errorMsg = errorMsg;
        this.originalDAmt = originalDAmt;
        this.originalPAmt = originalPAmt;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

        updateAmmount();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateAmmount();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateAmmount();
    }

    public void updateAmmount() {

        Double amountPaid = 0d;   //d is Double datatype
        if (originalDAmt.getText() == null || originalDAmt.getText().length() == 0) {
            amountPaid = 0d;
        } else {
            amountPaid = Double.valueOf(originalDAmt.getText());
        }

        Double amountPending = 0d;
        if (originalPAmt.getText() == null || originalPAmt.getText().length() == 0) {
            amountPending = 0d;
        } else {
            amountPending = Double.valueOf(originalPAmt.getText());
        }

        Double enterAmount = 0d;
        if (feamount.getText() == null || feamount.getText().length() == 0) {
            enterAmount = 0d;
        } else {
            enterAmount = Double.valueOf(feamount.getText());
        }

        Double rPrice = 0d;
        if (roomPrice.getText() == null || roomPrice.getText().length() == 0) {
            rPrice = 0d;
        } else {
            rPrice = Double.valueOf(roomPrice.getText());
        }

        if (enterAmount == 0) {
            fpamount.setText(originalPAmt.getText());
            famountp.setText(originalDAmt.getText());
            errorMsg.setVisible(false);
        } else if (enterAmount > amountPending) {
            fpamount.setText(originalPAmt.getText());
            famountp.setText(originalDAmt.getText());
            errorMsg.setText("Invalid Amount:Enter Amount Can Not Higher Then Pendinbg Amount");
            errorMsg.setVisible(true);
        } else if (enterAmount < amountPending) {
            Double newPendingAmt = amountPending - enterAmount;
            fpamount.setText(String.valueOf(newPendingAmt));

            Double newDepositAmt = amountPaid + enterAmount;
            famountp.setText(String.valueOf(newDepositAmt));
            errorMsg.setVisible(false);
        } else if (Objects.equals(enterAmount, amountPending)) {
            fpamount.setText("0");
            famountp.setText(roomPrice.getText());
            errorMsg.setVisible(false);
        }

        System.out.println("ENTER AMOUNT:" + feamount.getText());
    }
}
