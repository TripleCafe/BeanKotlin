package cn.com.triplecafe.beankotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_download_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            Toast.makeText(this.context, "点击了 button 1", Toast.LENGTH_SHORT).show();
        }

        view.findViewById<Button>(R.id.button_download_second).setOnClickListener {
            Toast.makeText(this.context, "点击了 button 2", Toast.LENGTH_SHORT).show()
        }
    }
}