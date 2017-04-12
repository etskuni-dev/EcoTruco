package mx.com.terceroa.alanvazquez.ecotruco;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Ingreso extends Activity implements View.OnClickListener {

    private Button Ingresar;
    private EditText Email, Pass;
    private TextView Registra;
    private ProgressDialog Progreso;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), Principal.class));
        }

        Progreso = new ProgressDialog(this);
        Ingresar = (Button)findViewById(R.id.buttonIngresar);
        Email = (EditText)findViewById(R.id.editTextEMail);
        Pass = (EditText)findViewById(R.id.editTextPassword);
        Registra = (TextView)findViewById(R.id.textViewSignUp);


        Ingresar.setOnClickListener(this);
        Registra.setOnClickListener(this);
    }

    private  void  Ingresa(){
        String email = Email.getText().toString().trim();
        String pass = Pass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //empty
            Toast.makeText(this, "Ingresa Email porfavor", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            //empty
            Toast.makeText(this, "Ingresa Contraseña porfavor", Toast.LENGTH_SHORT).show();
            return;
        }

        Progreso.setMessage("Ingresando...");
        Progreso.show();

        firebaseAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Progreso.dismiss();

                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), Principal.class));
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {

        if(v == Ingresar){
            Ingresa();
        }

        if(v == Registra){
            finish();
            startActivity(new Intent(this, Registro.class));
        }

    }

}
