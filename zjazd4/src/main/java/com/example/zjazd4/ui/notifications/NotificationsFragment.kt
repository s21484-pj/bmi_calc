package com.example.zjazd4.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zjazd4.R
import com.example.zjazd4.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var binding: FragmentNotificationsBinding? = null
    private var TVRecipies: TextView? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        val notificationsViewModel: NotificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        TVRecipies = root.findViewById(R.id.textViewRecipies)
        TVRecipies!!.text = getRecipe()
        return root
    }

    private fun getRecipe(): String? {
        return """
            Przepis na nalesniki
            Skladniki:
            1 szklanka mąki pszennej
            2 jajka
            1 szklanka mleka
            1/4 łyżeczki soli
            2 łyżki oleju roślinnego lub masła do smażenia
            farsz lub dodatki (np. dżem, ser, owoce, mięso, warzywa)
            
            Instrukcje:
            
            Wymieszaj w misce mąkę, jajka i sól. Stopniowo dodawaj mleko, ciągle mieszając, aż uzyskasz jednolitą masę bez grudek.
            
            Odstaw masę na około 15 minut, aby odpoczęła.
            
            Na patelni rozgrzej olej lub masło na średnim ogniu.
            
            Naleśniki smaż najlepiej na patelni z teflonową powłoką lub specjalną patelnią do naleśników.
            
            Wlej trochę masy na patelnię i rozprowadź ją równomiernie po całej powierzchni. Smaż naleśnik na złoty kolor z jednej strony, a następnie odwróć go i smaż z drugiej strony.
            
            Przełóż naleśnik na talerz i powtórz czynność dla pozostałej masy.
            
            Wypełnij naleśniki ulubionym farszem lub dodatkami. Możesz użyć dżemu, sera, owoców, mięsa lub warzyw.
            
            Zwiń naleśnik w trójkąt lub w rulonik.
            
            Podawaj na ciepło z dodatkami, takimi jak cukier puder, syrop klonowy lub śmietana.
            """.trimIndent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}