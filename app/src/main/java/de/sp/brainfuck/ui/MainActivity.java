package de.sp.brainfuck.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.sp.brainfuck.R;
import de.sp.brainfuck.core.BrainFuckInterpreter;
import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonMoveRight, buttonInterpret, buttonMoveLeft, buttonOutput, buttonIncrease, buttonDecrease, buttonInput, buttonOpeningBracket, buttonClosingBracket;
    private EditText codeEditText, inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codeEditText = findViewById(R.id.code);

        inputEditText = findViewById(R.id.input);

        buttonMoveRight = findViewById(R.id.buttonMoveRight);
        buttonMoveRight.setOnClickListener(this);

        buttonMoveLeft = findViewById(R.id.buttonMoveLeft);
        buttonMoveLeft.setOnClickListener(this);

        buttonOutput = findViewById(R.id.buttonOutput);
        buttonOutput.setOnClickListener(this);

        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonIncrease.setOnClickListener(this);

        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonDecrease.setOnClickListener(this);

        buttonInput = findViewById(R.id.buttonKomma);
        buttonInput.setOnClickListener(this);

        buttonOpeningBracket = findViewById(R.id.buttonLoopStart);
        buttonOpeningBracket.setOnClickListener(this);

        buttonClosingBracket = findViewById(R.id.buttonLoopEnd);
        buttonClosingBracket.setOnClickListener(this);

        buttonInterpret = findViewById(R.id.buttonShow);
        buttonInterpret.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (buttonMoveRight.isPressed()) {
            codeEditText.setText(codeEditText.getText().append(">"));
        }
        if (buttonMoveLeft.isPressed()) {
            codeEditText.setText(codeEditText.getText().append("<"));
        }
        if (buttonIncrease.isPressed()){
            codeEditText.setText(codeEditText.getText().append("+"));
        }
        if (buttonDecrease.isPressed()){
            codeEditText.setText(codeEditText.getText().append("-"));
        }
        if (buttonOutput.isPressed()){
            codeEditText.setText(codeEditText.getText().append("."));
        }
        if (buttonInput.isPressed()){
            codeEditText.setText(codeEditText.getText().append(","));
        }
        if (buttonOpeningBracket.isPressed()){
            codeEditText.setText(codeEditText.getText().append("["));
        }
        if (buttonClosingBracket.isPressed()){
            codeEditText.setText(codeEditText.getText().append("]"));
        }
        else if (buttonInterpret.isPressed()) {
            BrainFuckInterpreter interpreter = new BrainFuckInterpreter();
            try {
                String result = interpreter.interpret(codeEditText.getText().toString(), inputEditText.getText().toString());
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            } catch (InvalidCharacterException | MalformedBracketsException e) {
                Toast.makeText(getApplicationContext(), "Fehler", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
