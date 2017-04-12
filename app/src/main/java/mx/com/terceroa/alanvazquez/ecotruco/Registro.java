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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends Activity implements View.OnClickListener {

    private Button Registrar;
    private EditText Email, Password;
    private TextView IniciarSecion;
    private ProgressDialog Progreso;
    private FirebaseAuth firebaseAuth;
    private ImageView logoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), Principal.class));
        }

        Progreso = new ProgressDialog(this);

        Registrar = (Button) findViewById(R.id.buttonRegister);
        Email = (EditText) findViewById(R.id.editTextEMail);
        Password = (EditText) findViewById(R.id.editTextPassword);
        IniciarSecion = (TextView) findViewById(R.id.textViewSignIn);
        logoApp = (ImageView) findViewById(R.id.imageViewLogo);

        Registrar.setOnClickListener(this);
        IniciarSecion.setOnClickListener(this);

        Glide.with(this)
                .load("https://s-media-cache-ak0.pinimg.com/736x/12/b2/fe/12b2fe87fc23948f183fdd6b86445428.jpg")

                .into(logoApp);

    }

    private void Registrar(){
        String email = Email.getText().toString().trim();
        String pass = Password.getText().toString().trim();

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

        Progreso.setMessage("Registrando Usuario...");
        Progreso.show();

        firebaseAuth.createUserWithEmailAndPassword(email ,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Progreso.dismiss();

                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), Principal.class));
                        }else{
                            Toast.makeText(Registro.this, "No es posible hacer el Registro", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v == Registrar){
            Registrar();
        }

        if(v == IniciarSecion){
            finish();
            startActivity(new Intent(this, Ingreso.class));
        }
    }
}
