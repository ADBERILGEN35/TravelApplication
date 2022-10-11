package com.example.travelguideapplication.view




class StartedFragment : Fragment() {
    private lateinit var binding: FragmentStartedBinding
    private val startedFragmentViewModel: StartedFragmentViewModel by viewModels()

    private var adapter: TravelApiAdapter = TravelApiAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_started,
            container,
            false
        )
        viewPager()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        context?.let {

        }
    }

    private fun viewPager() {
        val titleList = arrayOf("All", "Flights", "Hotels", "Transportations")
        var pager = binding.viewPager
        val tl = binding.tabsApp
        pager.adapter = TabsAdaptor(childFragmentManager, lifecycle)
        TabLayoutMediator(tl, pager) { tab, position ->
            tab.text = titleList[position]
            pager.isUserInputEnabled = false

        }.attach()
    }


}

