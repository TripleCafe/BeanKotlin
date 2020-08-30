package cn.com.triplecafe.beankotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.*

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
			onClickFirstButton()
		}

		view.findViewById<Button>(R.id.button_download_second).setOnClickListener {
			Toast.makeText(this.context, "点击了 button 2", Toast.LENGTH_SHORT).show()
		}
	}

	fun onClickFirstButton() {
//		Toast.makeText(this.context, "点击了 button 1", Toast.LENGTH_SHORT).show()
		val textView = view?.findViewById<TextView>(R.id.textview_first)

		// Instantiate the RequestQueue
		val queue = Volley.newRequestQueue(this.context)
		val url = "https://www.baidu.com"

		// Request a string response from provided URL
		val stringRequest = StringRequest(Request.Method.GET, url,
			Response.Listener<String> { response ->
				// Display the first 500 characters of the response string.
				textView?.text = "Response is: ${response.substring(0, 500)}"
			},
			Response.ErrorListener { textView?.text = "That didn't work!" }
		)

		// Add the request to the RequestQueue
		queue.add(stringRequest)
	}
}
