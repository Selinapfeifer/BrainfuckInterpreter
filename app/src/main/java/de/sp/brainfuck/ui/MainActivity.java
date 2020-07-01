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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonMoveRight, buttonInterpret;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText = findViewById(R.id.editText);
        editText.setText("124423");
        buttonMoveRight = findViewById(R.id.buttonMoveRight);
        buttonMoveRight.setOnClickListener(this);
        buttonInterpret = findViewById(R.id.buttonShow);
        buttonInterpret.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(buttonMoveRight.isPressed()){
            editText.setText(editText.getText().append(">"));
        } else if(buttonInterpret.isPressed()){
            BrainFuckInterpreter interpreter = new BrainFuckInterpreter();
            try {
                String result = interpreter.interpret(editText.getText().toString());
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            } catch (InvalidCharacterException e) {
                Toast.makeText(getApplicationContext(),"Fehler",Toast.LENGTH_SHORT).show();              }
        }
    }
}
