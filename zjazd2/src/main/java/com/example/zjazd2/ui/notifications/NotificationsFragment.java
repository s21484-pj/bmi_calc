package com.example.zjazd2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.zjazd2.R;
import com.example.zjazd2.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView TVRecipies;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TVRecipies = root.findViewById(R.id.textViewRecipies);
        TVRecipies.setText(getRecipe());
        return root;
    }

    private String getRecipe() {
        return
                "Przepis na nalesniki\n" +
                        "Skladniki:\n" +
                        "1 szklanka mąki pszennej\n" +
                        "2 jajka\n" +
                        "1 szklanka mleka\n" +
                        "1/4 łyżeczki soli\n" +
                        "2 łyżki oleju roślinnego lub masła do smażenia\n" +
                        "farsz lub dodatki (np. dżem, ser, owoce, mięso, warzywa)\n\n" +
                        "Instrukcje:\n" +
                        "\n" +
                        "Wymieszaj w misce mąkę, jajka i sól. Stopniowo dodawaj mleko, ciągle mieszając, aż uzyskasz jednolitą masę bez grudek.\n" +
                        "\n" +
                        "Odstaw masę na około 15 minut, aby odpoczęła.\n" +
                        "\n" +
                        "Na patelni rozgrzej olej lub masło na średnim ogniu.\n" +
                        "\n" +
                        "Naleśniki smaż najlepiej na patelni z teflonową powłoką lub specjalną patelnią do naleśników.\n" +
                        "\n" +
                        "Wlej trochę masy na patelnię i rozprowadź ją równomiernie po całej powierzchni. Smaż naleśnik na złoty kolor z jednej strony, a następnie odwróć go i smaż z drugiej strony.\n" +
                        "\n" +
                        "Przełóż naleśnik na talerz i powtórz czynność dla pozostałej masy.\n" +
                        "\n" +
                        "Wypełnij naleśniki ulubionym farszem lub dodatkami. Możesz użyć dżemu, sera, owoców, mięsa lub warzyw.\n" +
                        "\n" +
                        "Zwiń naleśnik w trójkąt lub w rulonik.\n" +
                        "\n" +
                        "Podawaj na ciepło z dodatkami, takimi jak cukier puder, syrop klonowy lub śmietana."
                ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}