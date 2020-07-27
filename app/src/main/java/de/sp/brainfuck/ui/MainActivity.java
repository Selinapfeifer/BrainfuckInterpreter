package de.sp.brainfuck.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.sp.brainfuck.R;
import de.sp.brainfuck.core.BrainFuckInterpreter;
import de.sp.brainfuck.core.exception.InvalidCharacterException;
import de.sp.brainfuck.core.exception.MalformedBracketsException;
import de.sp.brainfuck.core.validation.ValidCharacters;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonMoveRight, buttonInterpret, buttonMoveLeft, buttonOutput, buttonIncrease, buttonDecrease, buttonInput, buttonOpeningBracket, buttonClosingBracket;
    private EditText codeEditText, inputEditText;
    TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codeEditText = findViewById(R.id.code);
        BrainFuckInterpreter interpreter = new BrainFuckInterpreter();

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
            addCharAfterCodeCursor(ValidCharacters.SHIFT_RIGHT);
        }
        if (buttonMoveLeft.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.SHIFT_LEFT);
        }
        if (buttonIncrease.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.INCREASE);
        }
        if (buttonDecrease.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.DECREASE);
        }
        if (buttonOutput.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.PRINT);
        }
        if (buttonInput.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.READ_INPUT);
        }
        if (buttonOpeningBracket.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.OPEN_BRACKET);
        }
        if (buttonClosingBracket.isPressed()) {
            addCharAfterCodeCursor(ValidCharacters.CLOSING_BRACKET);
        } else if (buttonInterpret.isPressed()) {
            interpretCode();
        }
    }

    private void addCharAfterCodeCursor(ValidCharacters validChar) {
        int cursorPosition = codeEditText.getSelectionStart();
        String prefix = codeEditText.getText().toString().substring(0, cursorPosition);
        String postfix = codeEditText.getText().toString().substring(cursorPosition);

        String code = prefix + validChar.getCharacter() + postfix;
        codeEditText.setText(code);
        codeEditText.setSelection(cursorPosition + 1);
    }

    private void interpretCode() {
        BrainFuckInterpreter interpreter = new BrainFuckInterpreter();
        try {
            String result = interpreter.interpret(codeEditText.getText().toString(), inputEditText.getText().toString());
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            textViewOutput = findViewById(R.id.textViewOutput);
            textViewOutput.setText(result + "");
        } catch (InvalidCharacterException | MalformedBracketsException e) {
            Toast.makeText(getApplicationContext(), "Fehler", Toast.LENGTH_SHORT).show();
        }
    }

}
