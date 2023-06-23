package com.example.appcompra;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText lista, numeroLista;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

              lista = findViewById(R.id.author_input);
        numeroLista = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoDados myDB = new BancoDados(AddActivity.this);
                myDB.addBook(lista.getText().toString().trim(),
                        lista.getText().toString().trim(),
                        Integer.valueOf(numeroLista.getText().toString().trim()));
            }
        });
    }
}
