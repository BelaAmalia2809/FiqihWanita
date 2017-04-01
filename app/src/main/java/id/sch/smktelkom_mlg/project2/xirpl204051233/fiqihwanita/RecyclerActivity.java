package id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.adapter.DataAdapter;
import id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.model.Data;

import static id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.MainActivity.JUDUL;

public class RecyclerActivity extends AppCompatActivity implements DataAdapter.IDataAdapter {

    public static final String INTENT_DETAIL = "intent detail";
    DataAdapter mDataAdapter;
    ArrayList<Data> datas1 = getKewajibanList();
    ArrayList<Data> datas2 = getSunnahList();
    ArrayList<Data> datas3 = getLaranganList();

    ArrayList<Data> datas = null;
    ArrayList<Data> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Intent intent = getIntent();
        String judul = intent.getStringExtra(JUDUL);
        int id = getIntent().getIntExtra(MainActivity.ID, 0);

        setTitle(judul);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (id == 1) {
            mDataAdapter = new DataAdapter(this, datas1);
            datas = datas1;
        } else if (id == 2) {
            mDataAdapter = new DataAdapter(this, datas2);
            datas = datas2;
        } else if (id == 3) {
            mDataAdapter = new DataAdapter(this, datas3);
            datas = datas2;
        }

        recyclerView.setAdapter(mDataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });

        return true;
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(datas);
            isFiltered = true;
        }

        datas.clear();
        if (query == null || query.isEmpty()) {
            datas.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Data data = mListAll.get(i);
                if (data.title.toLowerCase().contains(query)) {
                    datas.add(data);
                    mListMapFilter.add(i);
                }
            }
        }
        mDataAdapter.notifyDataSetChanged();
    }

    public ArrayList<Data> getKewajibanList() {
        ArrayList<Data> datas1 = new ArrayList<>();
        Data data = new Data("Kewajiban Berjilbab",
                "Wanita adalah salah satu makhluk yang diciptakan Allah SWTbesert dengan segala keistimewaannya. Setelah diciptakan wanita tidak dibiarkan begitu saja, ada peraturan khusus yang diterapkan Allah untuk para wanita. Peraturan-peraturan ini bukan untuk mengekang dan membuat wanita terpenjara.\n" +
                        "Namun peraturan ini justru melindungi dan memuliakan wanita itu sendiri. Salah satu peraturan bagi wanita yaitu berjilbab.\n" +
                        "\n" +
                        "Jilbab atau hijab secara syari’at merupakan bagian pakaian yang wajib digunakan untuk menutupi kepala wanita hingga ke dadanya. Muslimah perlu memperhatikan apa yang ia pakai. Apakah benar-benar sesuai hukum Allah atau tidak. \n" +
                        "\n" +
                        "Dalilnya adalah:\n" +
                        "“…Dan hendaklah mereka menutupkan kain kudung ke dadanya…” [QS. An-Nuur 24:31]. Artinya ialah bahwa Allah menghendaki agar para wanita menutup kain dari kepalanya hingga ke dadanya.\n" +
                        "\n" +
                        "“Hai Nabi, katakanlah kepada istri-istrimu, anak-anak perempuanmu, dan istri-istri orang-orang mukmin: ‘Hendaklah mereka mengulurkan jilbabnya ke seluruh tubuh mereka.’ Yang demikian itu supaya mereka lebih mudah untuk dikenal dan oleh karenanya mereka tidak diganggu. Dan Allah Maha Pengampun lagi Maha Penyayang.” (Qs. Al-Ahzab: 59).\n" +
                        "\n" +
                        "Batasan aurat bagi wanita :\n" +
                        "Ulama berbeda pendapat mengenai batasan aurat bagi wanita. Ulama Hanafi, Maliki dan salah satu pendapat dalam madzhab Syafi’i berpendapat seluruh tubuh wanita adalah aurat kecuali wajah dan telapak tangan. Sedangkan ulama Hambali salah satu pendapat dalam madzhab Syafi’i berpendapat bahwa seluruh tubuh wanita adalah aurat termasuk wajah dan telapak tangan. Namun pendapat yang rajih, dan ini juga merupakan pendapat yang diterapkan oleh mayoritas kaum Muslimin di negeri kita, bahwa aurat wanita adalah seluruh tubuh kecuali wajah dan telapak tangan. Kaki juga merupakan bagian aurat yang sering dilalaikan oleh muslimah.\n" +
                        "\n" +
                        "Alasan penghambat berjilbab :\n" +
                        "1.\t“saya belum siap berhijab”\n" +
                        "2.\t“lebih penting jilbab dari hati terlebih dahulu”\n" +
                        "3.\t“banyak wanita berhijab yang akhlaknya buruk, tidak sepadan dengan hijabnya”\n" +
                        "4.\t“saya belum dapat hidayah”\n" +
                        "\n" +
                        "Syarat pakaian penutup aurat :\n" +
                        "1. Menutup seluruh tubuh kecuali wajah dan telapak tangan.\n" +
                        "2. Tidak tipis dan tidak transparan\n" +
                        "3. Longgar dan tidak memperlihatkan lekuk-lekuk dan bentuk tubuh\n" +
                        "4. Bukan pakaian laki-laki atau menyerupai pakaian laki-laki.\n" +
                        "5. Tidak berwarna dan bermotif terlalu menyolok.Sebab pakaian yg menyolok akan mengundang perhatian laki-laki.\n",
                R.drawable.satu);
        datas1.add(data);

        data = new Data("Kewajiban Muslimah terhadap Hatinya",
                "Segala sesuatu yang bersifat materi saja tidak akan menjamin ketenangan dalam hati. Untuk itulah kewajiban inti ada pada pengisian hati agar semua proses kegiatan dapat berjalan baik. Untuk mengasah fungsi hati ada beberapa hal yang harus dilakukan, yaitu:\n" +
                        "•\tDzikrullah (mengingat Allah atau menyebut Allah),\n" +
                        "“Ingatlah hanya dengan mengingat Allah-lah hati menjadi tenang.” ( Ar-Raad, 28)\n" +
                        "Dzikir selain menentramkan hati juga mencerahkan pikiran, kecemerlangan akal dan hati karena senantiasa mengingat Allah SWT. Al-Hadits, “ Perumpaan orang yang berdzikir kepada tuhannya dengan orang yang tidak berzikir ibarat yang hidup dengan yang mati.” (HR. Bukhari)\n" +
                        "a. Membaca Al-qur’an\n" +
                        "b. Menjauhi maksiat\n" +
                        "c. Menjauhi ketergantungan pada makhluk\n" +
                        "d. Memperbanyak ibadah.\n",
                R.drawable.aw);

        datas1.add(data);

        data = new Data("Kewajiban Membayar Hutang Puasa",
                "Allah membolehkan, bagi orang yang tidak mampu menjalankan puasa, baik karena sakit yang ada harapan sembuh atau safar atau sebab lainnya, untuk tidak berpuasa, dan diganti dengan qadha di luar ramadhan. \n" +
                        "Setiap orang yang tidak berpuasa pada bulan ramadhan wajib menggantinya pada bulan lain.Bagaimana caranya?\n" +
                        "Sumber Al-Quran\n" +
                        " “Dan barangsiapa sakit atau dalam perjalanan (lalu ia berbuka), maka (wajiblah baginya berpuasa), sebanyak hari yang ditinggalkannya itu, pada hari-hari yang lain.” (QS. Al Baqarah: 184)\n" +
                        "\n" +
                        "Kemudian, para ulama mewajibkan, bagi orang yang memiliki hutang puasa ramadhan, sementara dia masih mampu melaksanakan puasa, agar melunasinya sebelum datang ramadhan berikutnya. \n" +
                        "Berdasarkan keterangan A’isyah radhiyallahu ‘anha, “Dulu saya pernah memiliki utang puasa ramadhan. Namun saya tidak mampu melunasinya kecuali di bulan sya’ban. (HR. Bukhari 1950 & Muslim 1146). ”. Dalam riwayat muslim terdapat tambahan,” Karena beliau sibuk melayani Rasulullah shallallahu ‘alaihi wa sallam”.\n" +
                        "A’isyah, istri tercinta Nabi shallallahu ‘alaihi wa sallam selalu siap sedia untuk melayani suaminya, kapanpun suami datang. Sehingga A’isyah tidak ingin hajat suaminya tertunda gara-gara beliau sedang qadha puasa ramadhan. Hingga beliau akhirkan qadhanya, sampai bulan sya’ban, dan itu kesempatan terakhir untuk qadha. Al-Hafidz Ibnu Hajar mengatakan, “Disimpulkan dari semangatnya A’isyah untuk mengqadha puasa di bulan sya’ban, menunjukkan bahwa tidak boleh mengakhirkan qadha puasa ramadhan, hingga masuk ramadhan berikutnya. (Fathul Bari, 4/191).”\n" +
                        "\n" +
                        "1.\tPertama, menunda qadha karena udzur, misalnya kelupaan, sakit, hamil, atau udzur lainnya. Dalam kondisi ini, dia hanya berkewajiban qadha tanpa harus membayar kaffarah. Karena dia menunda di luar kemampuannya. Imam Ibnu Baz rahimahullah pernah ditanya tentang orang yang sakit selama dua tahun. Sehingga utang ramadhan sebelumnya tidak bisa diqadha hingga masuk ramadhan berikutnya.\n" +
                        "“Dia tidak wajib membayar kaffarah, jika dia mengakhirkan qadha disebabkan sakitnya hingga datang ramadhan berikutnya. Namun jika dia mengakhirkan qadha karena menganggap remeh, maka dia wajib qadha dan bayar kaffarah dengan memberi makan orang miskin sejumlah hari utang puasanya.”\n" +
                        "\n" +
                        "2.\tKedua, sengaja menunda qadha hingga masuk ramadhan berikutnya, tanpa udzur atau karena meremehkan. Ada 3 hukum untuk kasus ini:\n" +
                        "•\tHukum qadha tidak hilang. Artinya tetap wajib qadha, sekalipun sudah melewati ramadhan berikutnya. Ulama sepakat akan hal ini.\n" +
                        "•\tKewajiban bertaubat. Karena orang yang secara sengaja menunda qadha tanpa udzur hingga masuk ramadhan berikutnya, termasuk bentuk menunda kewajiban, dan itu terlarang. Sehingga dia melakukan pelanggaran. Karena itu, dia harus bertaubat.\n" +
                        "•\tApakah dia harus membayar kaffarah atas keterlambatan ini ?.\n" +
                        "Jika dia tidak mamou mengqadha puasanya maka dia harus membayar fidyah dengan memberi makan orang miskin.\n",
                R.drawable.tiga);
        datas1.add(data);

        data = new Data("Kewajiban Merawat Anak dan Suami",
                "Sebagai istri yang solehah, sebaiknya istri tetap tinggal di rumah dan mengurus keluarganya. Anak biasanya lebih dekat dengan ibunya, itu sebabnya seorang wanita diwajibkan untuk mengurus anaknya. \n" +
                        "\n" +
                        "Pendidikan anak dimulai dari orang tua, terutama ibu. Lalu bagaimana dengan kewajiban istri kepada suami? Istri yang solehan adalah istri yang melayani suami dengan baik, terutama menuruti semua perintah suami.\n" +
                        "\n" +
                        "Apakah istri wajib melakukan pekerjaan rumah? Abdul Majid Mahmud Mathlub dalam kitabnya Al-Wajiz Fi Ahkamil Usroh al-Islamiyah dan Sayyid Sabiq dalam Fiqih Sunnah menjelaskan bahwa sebagian fuqaha berpandangan seorang suami tidak boleh menuntut istrinya secara hukum untuk melakukan pekerjaan rumah. \n" +
                        "\n" +
                        "Karena akad nikah yang terlaksana antara mereka berdua hanya bermaksud menghalalkan bergaul antara suami istri untuk menjaga kehormatan diri dan menghasilkan keturunan.\n" +
                        "\n",
                R.drawable.yaya);
        datas1.add(data);

        data = new Data("Kewajiban Membantu Kehidupan Suami",
                "Allah swt. berfirman :\n" +
                        "\"(Ingatlah) ketika istri Imran berkata: `Wahai Tuhanku, sesungguhnya aku menadzarkan kepada-Mu anak yang ada dalam kandunganku ini menjadi hamba yang shalih dan berkhidmat (di Baitul Maqdis). Karena itu, terimalah nadzar itu dariku. Sesungguhnya Engkaulah Yang Maha Mendengar lagi Maha Mengetahui. \"(QS. Ali Imran : 35)\n" +
                        "Penjelasan:\n" +
                        "Seorang istri mempunyai kewajiban berdakwah. Orang yang paling utama didakwahi adalah suaminya sendiri. Karena itu, tugas seorang istri membantu kehidupan beragama suaminya adalah fardhu 'ain. Maksudnya, kewajiban yang harus dilakukan tiap-tiap orang. Karenanya, istri adalah orang yang paling bertanggung jawab meluruskan perilaku suami yang tidak sejalan dengan ketentuan Islam.\n" +
                        "\n" +
                        "Contoh kiprah seorang istri yang membantu kehidupan agama suaminya ialah apa yang dilakukan oleh istri 'Imran as. Istri 'Imran ini merupakan suri tauladan bagi para istri dalam membantu suami menegakkan kehidupan beragama. Akhlak suami yang teguh pada agama harus selalu ditopang, bahkan terus diberi semangat supaya sang suami hidup di jalan yang diridlai Allah.\n" +
                        "\n" +
                        "Dalam ajaran Islam seorang istri tidak boleh acuh tak acuh terhadap kehidupan agama suaminya. Jika suaminya menyalahi ajaran agama, ia wajib meluruskannya. Jika suami memusuhi dakwah Islam, ia wajib menghentikannya. Dan jika suami menegakkan kehidupan Islam, maka ia wajib membantunya. Bila suami kurang pengetahuan Islamnya, sedang istri banyak tahu, maka ia wajib mengajari suaminya. Karena itu, istri wajib terus menerus belajar agama agar dapat membantu suaminya dalam menegakkan kehidupan beragama.\n",
                R.drawable.suami);
        datas1.add(data);


        data = new Data("Kewajiban Muslimah kepada Diri Sendiri",
                "1.\tMemelihara Kesucian Diri\n" +
                        "Kita sebagai manusia yang merupakan makhluq yang diciptakan Allah untuk selalu membersihkan diri dari berbagai macam hal yang bisa membuat diri kita menjadi kotor. Baik itu kesucian jasmani maupun rohani, haruslah senantiasa kita menjaganya, karena Allah pun menyukai orang-orang yang senantiasa membersihkan diri.\n" +
                        "\n" +
                        "“Janganlah kamu bersembahyang dalam mesjid itu selama-lamanya. Sesungguhnya mesjid yang didirikan atas dasar takwa (mesjid Quba), sejak hari pertama adalah lebih patut kamu sholat di dalamnya. Di dalamnya mesjid itu ada orang-orang yang ingin membersihkan diri. Dan sesungguhnya Allah menyukai orang-orang yang bersih” (Q.S At-Taubah : 108)\n" +
                        "2.\tMemelihara Kerapihan Diri\n" +
                        "\n" +
                        "Selain menjaga kesucian diri, baik itu jasmani maupun rohani, kita juga diperintahkan untuk selalu memelihara kerapihan diri kita, agar ketika dipandang dapat menyenangkan hati orang yang memandang. Dalam firman-Nya, Allah SWT juga memerintahkan kita untuk selalu memelihara kerapihan kita.\n" +
                        "\n" +
                        "“Hai anak Adam! Pakailah perhiasan kalian setiap waktu shalat” (Q.S Al-A’rof : 31)\n" +
                        "\n" +
                        "Dalam ayat ini Allah memerintahkan kita untuk selalu tampil rapih dan indah, bahkan ketika waktu shalat pun Allah memerintahkannya, karena sesungguhnya Allah melihat kita, jika kita tampil indah dihadapan Allah, Allah pasti akan menyukai dan senang terhadap kita. Sesungguhnya Allah itu indah dan menyukai keindahan.\n" +
                        "\n" +
                        "“Sesungguhnya Allah itu indah dan menyukai keindahan (H.R Muslim)\n" +
                        "3.\tBerlaku Tenang\n" +
                        "\n" +
                        "Ketenangan dalam sikap merupakan sebagian dari rangkaian akhlaqul karimah, sebagaimana dikemukakan dalam Al-Quran.\n" +
                        "\n" +
                        "“Dan para hamba Allah yang berjalan diatas bumi dengan tenang, dan bila ditegur oleh orang yang bodoh, mereka berkata ‘selamat’.” (Q.S Al-Furqon : 63)\n" +
                        "\n" +
                        "Sementara itu juga dijelaskan pul aoleh baginda Rosulullah SAW dalam sebuah hadis :\n" +
                        "\n" +
                        "“Sikap terburu-buru itu termasuk dari (gangguan) Syaithan” (H.R Tirmidzi)\n" +
                        "\n",
                R.drawable.hati);
        datas1.add(data);


        data = new Data("Kewajiban Muslimah terhadap Akalnya",
                "Manusia adalah makhluk ciptaan Allah yang sempurna dalam proses penciptaannya.\n" +
                        "Allah berfirman,”Sesungguhnya Kami menciptakan manusia dalam bentuk yang sebaik-baiknya.” Q.S. At-Tiin,95:4)\n" +
                        "Keistimewaan manusia adalah dengan dianugrahinya kemampuan akal dengan segala kapasitasnya. Sejak kehamilan di minggu ke-3 otak manusia akan terus berkembang secara pesat dan cepat dengan kemampuan yang menakjubkan. Kelebihan otak manusia yg diberikan Allah SWT ini adalah dengan berfungsinya akal. Inilah yang membedakannya dgn binatang.\n" +
                        "\n" +
                        "Muslimah potensi yang tidak kalah dibandingkan dengan laki-laki. Akal yg dikaruniakan Allah kepada manusia haruslah dijaga dengan baik dari hal-hal yang merusak akal baik dari segi fungsi dan kesehatannya. Menjaga kesehatan akal adalah dengan memilih makanan dan minuman yg menyehatkan bukan yang merusakan misalnya khamr/memabukkan. Diriwayatkan dari Ibnu Abbas r.a Bahwa Nabi SAW bersabda,”Semua yang mengacaukan akal dan semua yang memabukkan adalah haram.” (HR. Abu Daud)\n" +
                        "\n" +
                        "Dari segi penjagaan fungsi akal, adalah dengan mengisi akal dengan informasi yang bermanfaat. Ilmu dan informasi yang bermanfaat akan menjadikan makanan yang bergizi buat otak. Ilmu dan informasi itu berupa, pengetahuan keislaman. Syaikh Said Hawa menyebutkan beberapa ilmu islam yang harus diketahui setiap muslim meliputi 10 jenis yaitu :\n" +
                        "\n" +
                        "– Ilmu tentang pengenalan Allah, rasul dan Islam itu sendiri.\n" +
                        "– Ilmu tentang Al-qur’an baik kandungannya, sebab-sebabnya, cara membacanya.\n" +
                        "– Ilmu tentang As-sunnah, baik kandungannya, sanadnya.\n" +
                        "– Ilmu tentang Ushul Fiqh yaitu ilmu yang berbicara tetang kaidah2 dasar yang dipergunakan untuk\n" +
                        "memutuskan suatu dasar hokum dari dalil2 yg global.\n" +
                        "– Ilmu tentang Aqidah, akhlak dan fiqih\n" +
                        "– Ilmu tentang sirah nabawiyah dan tarikh umat islam (sejarah islam)\n" +
                        "– Ilmu bahasa arab untuk mendalami materi Al-qur’an, hadits nabi, fiqih,dsb.\n" +
                        "– Ilmu tentang system musuh dalam menghancurkan islam (deislamisasi). Terutama yang berkaitan dengan ghozul fikr (perang pemikiran).\n" +
                        "– Ilmu tentang islam kontemporer\n" +
                        "– Ilmu ttg fiqh dakwah, yaitu aturan dan tata cara dalam menyampaikan islam/dakwah.\n" +
                        "\n" +
                        "Dengan mengusai penuh salah satu ilmu diatas diharapkan akan lahir ulama-ulama muslimah yang akan membantu memecahkan masalah keumatan terutama masalah-masalah tentang wanita.\n" +
                        "\n" +
                        "Kemudian pengetahuan lain yang diperlukan adalah ilmu umum dan wawasan kontemporer. Dari sekian banyak ilmu umum, ada fardhu kifayah bagi muslimah untuk menguasai salah satu dari bidang-bidang tersebut, mendalaminya sehingga bisa professional. Dengan tersedianya ahli-ahli muslimah di bidang umum, akan sangat membantu kesulitan umat. Terutama dalam mengatasi masalah kewanitaan. Misalnya bidang kesehatan, bidang advokasi/hukum, bidang psikoligi, teknik, tata busana, kecantikan, dll.\n" +
                        "\n" +
                        "Dibidang kekinian pun muslimah dituntut untuk mengikuti perkembangan informasi dari berbagai dunia, ttg politik, nilai mata uang, seni dan budaya, olah raga,dll. Dengan wawasan yang luas akan sangat membantu muslimah dalam mengaktualisasikan dirinya di keluarga (dalam mendidik anak atau ngobrol ama suami nyambung..) atau dalam masyarakat.\n" +
                        "Pengetahuan yang lain adalah keterampilan teknis. Tanpa ada ahli dibidang-bidang teknis, muslimah akan mengalami keuslitan teknis yang semestinya tidak perlu terjadi apabila ilmunya dimiliki. Seperti computer, internet, dan sarana informasi lain.\n",
                R.drawable.akal);
        datas1.add(data);


        data = new Data("Kewajiban Taat kepada Suami",
                "Ketaatan istri pada suami adalah jaminan surganya. Dari Abu Hurairah radhiyallahu ‘anhu, Rasulullah shallallahu ‘alaihi wa sallam bersabda, “Jika seorang wanita melaksanakan shalat lima waktunya, melaksanakan shaum pada bulannya, menjaga kemaluannya, dan mentaati suaminya, maka ia akan masuk surga dari pintu mana saja ia kehendaki.” (HR Ibnu Hibban dalam Shahihnya)\n" +
                        "\n" +
                        "Suami adalah surga atau neraka bagi seorang istri. Keridhoan suami menjadi keridhoan Allah. Istri yang tidak diridhoi suaminya karena tidak taat dikatakan sebagai wanita yang durhaka dan kufur nikmat.\n" +
                        "\n" +
                        "Suatu hari Rasulullah shallallahu ‘alaihi wa sallam pernah bersabda bahwa beliau melihat wanita adalah penghuni neraka terbanyak. Seorang wanita pun bertanya kepada beliau mengapa demikian? Rasulullah pun menjawab bahwa diantarantanya karena wanita banyak yang durhaka kepada suaminya. (HR Bukhari Muslim)\n" +
                        "\n" +
                        "Kedudukan hak suami :\n" +
                        "Dari Abu Hurairah radhiyallahu ‘anhu, Rasulullah shallallahu ‘alaihi wa sallam bersabda, “Kalau aku boleh memerintahkan seseorang untuk sujud kepada orang lain, maka aku akan memerintahkan para istri untuk sujud kepada suaminya, disebabkan karena Allah telah menetapkan hak bagi para suami atas mereka (para istri). (HR Abu Dawud, Tirmidzi, ia berkata, “hadis hasan shahih.” Dinyatakan shahih oleh Syaikh Albani)\n" +
                        "\n" +
                        "Hak suami berada diatas hak siapapun manusia termasuk hak kedua orang tua. Hak suami bahkan harus didahulukan oleh seorang istri daripada ibadah-ibadah yang bersifat sunnah.\n" +
                        "\n" +
                        "Berbakti kepada suami:\n" +
                        "Diantara kewajiban seorang istri atas suaminya juga adalah, hendaknya seorang istri benar-benar menjaga amanah suami di rumahnya, baik harta suami dan rahasia-rahasianya, begitu juga bersungguhnya-sungguh mengurus urusan-urusan rumah.\n" +
                        "\n" +
                        "Rasulullah shallallahu ‘alaihi wa sallam bersabda, “Dan wanita adalah penanggungjawab di rumah suaminya, dan ia akan dimintai pertanggungjawaban.” (HR Bukhari Muslim)\n" +
                        "Syaikhul Islam berkata, “Firman Allah, “Sebab itu maka wanita yang saleh, ialah yang taat kepada Allah lagi memelihara diriketika suaminya tidak ada, oleh karena Allah telah memelihara (mereka).” (QS. An Nisa [4]: 34)\n" +
                        "\n" +
                        "Tidak keluar rumah kecuali dengan izin suami:\n" +
                        "Seorang istri juga tidak boleh keluar rumah kecuali dengan izin suami. Karena tempat asal wanita itu di rumah. Sebagaimana firman Allah, “Dan tinggal-lah kalian (para wanita) di rumah-rumah kalian.” (QS. Al Ahzab [33]: 33). Dengan demikian, wanita tidak boleh keluar rumah melainkan untuk urusan yang penting atau termasuk kebutuhan seperti memasak dan lain-lain. Jika bukan urusan tersebut, maka seorang istri tidak boleh keluar rumah melainkan dengan izin suaminya.\n" +
                        "\n" +
                        "Syaikhul Islam berkata, “Tidak halal bagi seorang wanita keluar rumah tanpa izin suaminya, jika ia keluar rumah tanpa izin suaminya, berarti ia telah berbuat nusyuz (durhaka), bermaksiat kepada Allah dan Rasul-Nya, serta layak mendapat hukuman.”\n",
                R.drawable.empat);
        datas1.add(data);


        return datas1;
    }

    public ArrayList<Data> getSunnahList() {
        ArrayList<Data> datas2 = new ArrayList<>();
        Data data2 = new Data("Tiga Orang Tamu",
                "Suatu ketika, ada seorang wanita yang kembali pulang ke rumah dari perjalanannya keluar rumah, dan ia melihat ada 3 orang pria berjanggut yang duduk di halaman depan. Wanita itu tidak mengenal mereka semua.\n" +
                        "\n" +
                        "Wanita itu berkata dengan senyumnya yang khas: “Aku tidak mengenal Anda, tapi aku yakin Anda semua pasti orang baik-baik yang sedang lapar. Mari masuk ke dalam, aku pasti punya sesuatu untuk mengganjal perut”.\n" +
                        "\n" +
                        "Pria berjanggut itu lalu balik bertanya, “Apakah suamimu sudah pulang?”\n" +
                        "\n" +
                        "Wanita itu menjawab, “Belum, dia sedang keluar”.\n" +
                        "\n" +
                        "“Oh kalau begitu, kami tak ingin masuk. Kami akan menunggu sampai suamimu kembali”, kata pria itu.\n" +
                        "\n" +
                        "Di waktu senja, saat keluarga itu berkumpul, sang isteri menceritakan semua kejadian tadi. Sang suami, awalnya bingung dengan kejadian ini, lalu ia berkata pada istrinya, “Sampaikan pada mereka, aku telah kembali, dan mereka semua boleh masuk untuk menikmati makan malam ini”.\n" +
                        "\n" +
                        "Wanita itu kemudian keluar dan mengundang mereka untuk masuk ke dalam.\n" +
                        "\n" +
                        "“Maaf, kami semua tak bisa masuk bersama-sama” , kata pria itu hampir bersamaan.\n" +
                        "\n" +
                        "“Lho, kenapa? tanya wanita itu karena merasa heran.\n" +
                        "\n" +
                        "Salah seseorang pria itu berkata, “Nama dia Kekayaan,” katanya sambil menunjuk seorang pria berjanggut disebelahnya, “sedangkan yang ini bernama Kesuksesan, sambil memegang bahu pria berjanggut lainnya.\n" +
                        "\n" +
                        "Sedangkan aku sendiri bernama Kasih-Sayang.\n" +
                        "Sekarang, coba tanya kepada suamimu, siapa diantara kami yang boleh masuk kerumahmu.”\n" +
                        "\n" +
                        "Wanita itu kembali masuk kedalam, dan memberitahu pesan pria di luar. Suaminya pun merasa heran. “Ohho…menyenangka n sekali. Baiklah, kalau begitu, coba kamu ajak si Kekayaan masuk ke dalam. Aku ingin rumah ini penuh dengan Kekayaan.”\n" +
                        "\n" +
                        "Istrinya tak setuju dengan pilihan itu. Ia bertanya, “sayangku, kenapa kita tak mengundang si Kesuksesan saja? Sebab sepertinya kita perlu dia untuk membantu keberhasilan panen ladang pertanian kita.”\n" +
                        "\n" +
                        "Ternyata, anak mereka mendengarkan percakapan itu. Ia pun ikut mengusulkan siapa yang akan masuk ke dalam rumah. “Bukankah lebih baik jika kita mengajak si Kasih-sayang yang masuk ke dalam? Rumah kita ini akan nyaman dan penuh dengan kehangatan Kasih-sayang. ”\n" +
                        "\n" +
                        "Suami-istri itu setuju dengan pilihan buah hati mereka. “Baiklah, ajak masuk si Kasih-sayang ini ke dalam. Dan malam ini, Si Kasih-sayang menjadi teman santap malam kita.”\n" +
                        "\n" +
                        "Wanita itu kembali ke luar, dan bertanya kepada 3 pria itu. “Siapa diantara Anda yang bernama Kasih-sayang? Ayo, silahkan masuk, Anda menjadi tamu kita malam ini.”\n" +
                        "\n" +
                        "Si Kasih-sayang berdiri, dan berjalan menuju beranda rumah. Ohho.. ternyata, kedua pria berjanggut lainnya pun ikut serta. Karena merasa ganjil, wanita itu bertanya kepada si Kekayaan dan si Kesuksesan.\n" +
                        "\n" +
                        "“Aku hanya mengundang si Kasih-sayang yang masuk ke dalam, tapi kenapa kamu ikut juga?”\n" +
                        "\n" +
                        "Kedua pria yang ditanya itu menjawab bersamaan. “Kalau Anda mengundang si Kekayaan, atau si Kesuksesan, maka yang lainnya akan tinggal di luar. Namun, karena Anda mengundang si Kasih-sayang, maka, kemana pun Kasih sayang pergi, kami akan ikut selalu bersamanya. Dimana ada Kasih-sayang, maka kekayaan dan Kesuksesan juga akan ikut serta. Sebab, ketahuilah, sebenarnya kami berdua ini buta. Dan hanya si Kasih-sayang yang bisa melihat. Hanya dia yang bisa menunjukkan kita pada jalan kebaikan, kepada jalan yang lurus. Maka, kami butuh bimbingannya saat berjalan. Saat kami menjalani hidup ini.”\n",
                R.drawable.tamu);
        datas2.add(data2);

        data2 = new Data("Istri yang Setia",
                "Kisah nyata ini saya dapatkan dari kitab ‘Uqudulujain. Sebuah kitab yang banyak dikaji di berbagai pondok pesantren di Indonesia. Kitab karya Syaikh Nawawi Al-Bantani ini cukup populer karena merupakan salah satu kitab yang membahas tentang tata cara hidup berumah tangga yang islami.\n" +
                        "Semoga kisah yang ditulis kembali ini dapat menginspirasi para wanita khusunya yang hendak/sudah membina mahligai rumah tangga agar mendapatkan berkah dalam pernikahannya. Kisah setia ini terjadi pada zaman Rasulullah SAW.\n" +
                        "Isteri yang taat Suami, bebas untuk masuk Surga\n" +
                        "\n" +
                        "Ketika Rasulullah S.A.W masih ada, tersebutlah seorang istri yang shalihah. Wanita setia ini begitu taat kepada suaminya. Suatu hari, karena kewajiban Agama untuk pergi berjihad, sang suami hendak berangkat memenuhi panggilan suci untuk berjihad dia berpesan pada istrinya “Istriku tersayang\n" +
                        "yang kucintai, aku akan pergi untuk berjihad meninggikan kalimat-kalimat Allah, sebelum aku kembali pulang dari berjihad, kamu jangan pergi kemanapun dan jangan keluar dari rumah ini”. Setelah berpesan demikian pada istrinya, berangkatlah si suami menuju medan jihad.\n" +
                        "Beberapa hari berlalu, datanglah seseorang kepada wanita tersebut yang mengabarkan bahwa Ibunya sedang sakit parah. Orang yang diutus tersebut mengatakan pada wanita shalihah tersebut untuk segera menjenguk Ibunya.\n" +
                        "“Ibumu saat ini sedang sakit keras, jenguklah dia sekarang”\n" +
                        "Dengan gelisah wanita tersebut menjawab “Saya mohon maaf yang sebesar-besarnya, bukannya tidak mau menjenguk, tapi saya dilarang keluar rumah sebelum suami saya pulang, tolong sampaikan permohonan maaf dan salam saya pada Ibu”. Si utusanpun pulang kembali tanpa membawa wanita tersebut.\n" +
                        "Malam berlalu dan suami yang berjihad belum juga pulang. Keesokan harinya datang kembali seorang utusan yang mengabarkan bahwa Ibu wanita tersebut meninggal dunia. Betapa sedih perasaan wanita tersebut, air matanya berlinang mendengar kabar Ibu yang dicintainya telah pergi untuk selama-lamanya, bahkan disaat terakhirnya dia tidak berada disampingnya.\n" +
                        "Utusan tersebut berkata “sekarang Ibumu telah tiada, datanglah untuk memberikan penghormatan terakhir sebelum beliau akan dikebumikan hari ini”. Namun istri yang shalihah ini sambil menangis tersedu menjawab “Bukanya saya tidak mencintai Ibu saya, tapi saya memegang amanah suami saya untuk tidak keluar rumah hingga dia pulang dan memberi saya izin”.\n" +
                        "Dengan berat utusan tersebut pulang. Mungkin karena kesal dan heran dengan sikap wanita tersebut yang tidak mau datang walaupun Ibunya sakit keras hingga meninggal dunia, dia adukan masalah tersebut pada Rasulullah S.A.W.\n" +
                        "Dengan nada sedikit kesal ia berkata kepada Nabi SAW, “Wahai Rasulullah, wanita itu sangat keterlaluan, dari mulai Ibunya sakit hingga meninggal dunia dia tidak mau datang untuk menemui Ibunya”.\n" +
                        "\n" +
                        "Rasulullah bertanya “Kenapa dia tidak mau datang?”\n" +
                        "\n" +
                        "“Wanita itu mengatakan bahwa dia tidak mendapata izin untuk keluar rumah sebelum suaminya pulang berjihad”, jawab utusan yang mengadu ke Rasulullah SAW tersebut.\n" +
                        "Rasulullah SAW tersenyum, kemudian beliau berkata “Dosa-dosa Ibu wanita tersebut diampuni Allah SWT karena dia mempunyai seorang puteri yang sangat taat terhadap suaminya”.\n" +
                        " \n",
                R.drawable.ks);
        datas2.add(data2);

        data2 = new Data("Lelaki Empat Istri",
                "ISTRI ke-1 : Tua dan biasa saja, biasanya tidak diperhatikan.\n" +
                        "Istri ke-2 : Agak cakep, agak diperhatikan.\n" +
                        "Istri ke-3 : Lumayan cakep dan cukup diperhatikan.\n" +
                        "Istri ke-4: Sangat cakep, sangat diperhatikan dan disanjung-sanjung serta diutamakan!\n" +
                        "Waktu pun berlalu begitu cepat dan tibalah saat sang lelaki (suami) tersebut mau meninggal, lalu dipanggilah 4 (empat) orang istrinya.\n" +
                        "Dipanggilah istri ke-4 yang paling cakep dan ditanya, “Maukah ikut menemaniku ke alam kubur ?”\n" +
                        "Si istri menjawab., “Maaf, cukup sampai di sini saja saya ikut denganmu.”\n" +
                        "Saat dipanggil istri ke-3 dan ditanya hal yang sama, dia pun menjawab, “Maaf, saya hanya akan mengantarmu sampai di kamar mayat dan paling jauh sampai di rumah duka.”\n" +
                        "Kemudian dipanggil istri ke-2 dan ditanya hal yang sama, maka dia pun menjawab, “Baik, saya akan menemanimu tapi hanya sampai ke liang kubur, setelah itu selamat tinggal.”\n" +
                        "Si Suami sungguh kecewa mendengar semua itu. Tetapi inilah kehidupan dan menjelang kematian.\n" +
                        "Lalu dipanggil lah istri ke-1 dan ditanya hal yang sama, si suami tak menyangka akan jawabannya, “Saya akan menemani ke manapun kamu pergi dan akan selalu mendampingimu…”\n" +
                        "Mau tahu apa dan siapa istri ke-1 sampai ke-4 itu?\n" +
                        "Istri ke-4 adalah “harta dan kekayaan”. Mereka akan meninggalkan jasad kita seketika saat kita meninggal.\n" +
                        "Istri ke-3 adalah “teman-teman” kita. Mereka hanya akan mengantar jasad kita hanya sampai di saat disemayamkan.\n" +
                        "Istri ke-2 adalah keluarga, famili, saudara dan teman dekat kita.\n" +
                        "Mereka akan mengantar kita sampai dikuburkan, dan akan meninggalkan kita setelah mayat kita dimasukkan dalam liang kubur dan ditutup dengan tanah.\n" +
                        "Istri ke-1 adalah “tindakan dan perbuatan” kita selama hidup di dunia. Karena apa yang ditabur orang, itu juga yang akan dituainya.\n" +
                        "Berbuatlah sebanyak mungkin kebaikan, kebajikan selama kita masih hidup di dunia ini, dalam sisa hidup, selagi waktu masih ada.\n" +
                        " \n",
                R.drawable.kd);
        datas2.add(data2);

        data2 = new Data("8 Kebohongan Ibu",
                "1. Kebohongan Ibu yang Pertama\n" +
                        "Demi mencukupi kebutuhan makan lauk untuk si anak, sang ibu memilih untuk pergi ke sungai dekat rumah untuk memancing ikan disana. Tidak mudah baginya untuk bisa mengusahakan umpannya dimakan oleh ikan. Dengan penuh kesabaran dan menghabiskan waktu hingga setengah hari, sang ibu akhirnya bisa mendapatkan ikan yang sama besarnya dengan telapak tangannya.\n" +
                        "Sang ibu segera pulang ke rumah untuk membuatkan sup ikan untuk si anak. Sang ibu tahu betul anak lelakinya sangat menyukai sup ikan. Segera setelah matang, disuguhkannya sup itu untuk anaknya.\n" +
                        "Sang ibu duduk di samping anaknya yang dengan lahap makan nasi dan sup ikan. Si anak memilah-milah tulang ikan ke piring yang lebih kecil. Sang ibu dengan tangannya mengambil daging ikan yang sebagian masih menempel di tulang tersebut kemudian memakannya.\n" +
                        "Melihat apa yang dilakukan ibunya tersebut, si anak berinisiatif untuk memberikan sedikit bagian kepala ikan tersebut kepada ibunya. Namun sang ibu dengan lembut menolak pemberian anaknya tersebut seraya berkata, “Makanlah nak, untuk kamu saja. Ibu tidak terlalu suka ikan sebenarnya. Tadi ibu hanya ingin mencicipi rasa dagingnya saja.”\n" +
                        "2. Kebohongan Ibu yang Kedua\n" +
                        "Saat si anak menginjak Sekolah Menengah Pertama, ibu membuat kerajinan dari barang bekas yang di jual ke koperasi desa. Hampir setiap hari ibu membuat kerajinan dari barang bekas tersebut. Hasil penjualannya selain bisa untuk mencukupi kebutuhan keluarga sehari-hari, juga untuk membiayai sekolah si anak.\n" +
                        "Suatu kali, si anak terbangun dari tidur malamnya setelah dikejutkan oleh gelegar bunyi guntur. Kamar tidurnya gelap gulita karena seluruh aliran listrik diputus sementara karena hujan deras dan guntur yang bersahutan malam itu. Namun  si anak melihat cahaya lilin di ruang depan. Ia mendapati sang ibu masih mengerjakan kerajinan dengan penerangan satu buah lilin saja.\n" +
                        "Si anak menghampiri ibunya dan  berkata, “Ibu, tidurlah, sudah malam dan juga gelap tidak ada listrik. Ibu bisa lanjutkan besok.”\n" +
                        "Sang Ibu tersenyum dan berkata, “Guntur membangunkanmu? Kamu tidurlah duluan, kamu kan harus sekolah besok pagi-pagi, Ibu belum mengantuk kok.”\n" +
                        "3. Kebohongan Ibu yang Ketiga\n" +
                        "Saat ujian sekolah, seperti ibu-ibu lainnya, sang ibu ingin menemani sang anak untuk menghadapi ujian. Namun tidak seperti ibu lainnya, sang ibu harus tidak bekerja pada hari itu demi sang anak. Tidak seperti ibu lainnya juga yang menunggu di kantin depan sekolah, sang ibu menunggu sang anak di bawah pohon yang bahkan tidak meneduhkannya dari sinar matahari.\n" +
                        "Saat tengah hari lonceng tanda ujian berakhir dibunyikan. Sang ibu segera menyambut si anak dengan penuh senyum dan segera menuangkan teh dingin yang tak lagi dingin.\n" +
                        "Si anak melihat sang ibu mukanya kemerahan di papar matahari dan bulir-bulir keringat menghiasi wajahnya. Si anak kemudian meminta ibunya saja yang meminum teh tersebut. Namun Ibu menjawab, “Minumlah nak, aku tidak haus!”\n" +
                        "4. Kebohongan Ibu yang Keempat\n" +
                        "Sepeninggal ayah, Ibu adalah juga kepala rumah tangga. Hidup terasa makin sulit setelah ayah tiada. Banyak tetangganya dan juga keluarga besar ibu memintanya untuk menikah lagi demi anak.\n" +
                        "Namun sang ibu punya jawaban sendiri kepada si anak yang juga atas permintaan untuk menikah lagi tersebut, “Saya lebih senang bersama kamu anakku.”\n" +
                        "5. Kebohongan Ibu yang Kelima\n" +
                        "Setelah si anak menamatkan sekolah dan mulai bekerja di kota, sang ibu tetap bekerja untuk kebutuhan kesehariannya. Si anak sudah memintanya untuk tidak lagi bekerja dan akan memberinya uang untuk sang ibu berapapun yang dibutuhkannya.\n" +
                        "Namun sang ibu menolak pemberian anaknya tersebut seraya berkata,”Tabunglah ini untuk mu dan masa depanmu, Ibu masih punya simpanan dan hasil penjualan ini masih cukup untuk ibu membeli makan.”\n" +
                        "6. Kebohongan Ibu yang Keenam\n" +
                        "Si anak berhasil meraih gelar sarjana setelah kuliah sambil bekerja. Ia pun akhirnya mendapatkan beasiswa melanjutkan kuliah di luar negeri. Tidak hanya kuliah, si anak juga mendapatkan pekerjaan di salah satu perusahaan di luar negeri. Ia pun ingin mengajak ibunya untuk tinggal bersamanya.\n" +
                        "Tetapi Ibu yang baik hati, bermaksud tidak mau merepotkan anaknya, ia berkata kepadaku, “Aku lebih suka disini.”\n" +
                        "7. Kebohongan Ibu yang Ketujuh\n" +
                        "Setelah meraih gelar master di luar negeri, si anak diterima sebagai pegawai tetap di luar negeri. Ia mulai sibuk dan mulai jarang menghubungi ibunya. Sampai suatu hari, pamannya memberi kabar bahwa sang ibu di rawat di rumah sakit karena penyakit kanker stadium akhir.\n" +
                        "Tanpa pikir panjang, si anak pulang menempuh jarak ribuan kilometer demi ibunda tercinta. Sesampainya di rumah sakit, si anak mendapati sang ibu yang sudah terlihat tua, terbaring lemah di ranjangnya. Ia baru saja menjalani operasi hari itu.\n" +
                        "Saat terbangun dari tidurnya, sang ibu tersenyum kepada si anak. Senyuman yang berbeda, karena senyum itu tampak seperti sedang menahan rasa sakit.\n" +
                        "Si anak menatap sang ibu sambil berlinang air mata. Hatinya perih, dadanya terasa sesak demi melihat sang ibu yang sakit dengan kondisi kurus dan sangat lemah. Tetapi Ibu dengan tegarnya berkata, “Jangan menangis anakku, Aku tidak kesakitan.”\n" +
                        "8. Kebohongan Ibu yang Terakhir\n" +
                        "Setelah kebohongannya yang terakhir tersebut, sang ibu tak mampu lagi tersenyum untuk si anak. Matanya tertutup untuk selama-lamanya.\n" +
                        "Itulah kisah kebohongan penuh rasa cinta dari ibu kepada anaknya. Semoga mampu memberi pembaca inspirasi untuk lebih meluangkan banyak waktu untuk orangtua khususnya ibu. Lebih sering manakah kamu menelepon ibu dari kekasihmu? Bahkan sekedar untuk menanyakan sudah makan atau belum?\n" +
                        "Muliakanlah orangtua khususnya ibu kamu terlebih dahulu sebelum mencoba untuk memuliakan dan memberi perhatian lebih kepada orang lain atau pasangan. Semoga kisah ini dapat menumbuhkan cinta yang lebih dalam kepada ibu dan ayah kita, Amiiin.\n" +
                        "\n",
                R.drawable.kt);
        datas2.add(data2);

        data2 = new Data("Ketulusan",
                "Alkisah di sebuah rumah mewah yang terletak dipinggiran sebuah kota, hiduplah sepasang suami istri. Dari sekilas orang yang memandang, mereka adalah pasangan yang sangat harmonis. Para tetangganya pun tahu bagaimana usaha mereka dalam meraih kehidupan mapan yang seperti saat ini. Sayang, pasangan itu belum lengkap. Dalam kurun waktu sepuluh tahun pernikahan mereka, pasangan itu belum juga dikaruniai seorang anak pun yang mereka harapkan.\n" +
                        "\n" +
                        "Karenanya walaupun masih saling mencinta, si suami berkeinginan menceraikan istrinya karena dianggap tak mampu memberikan keturunan sebagai penerus generasinya. Setelah melalui perdebatan sengit, dengan sedih dan duka yang mendalam, si istri akhirnya menyerah pada keputusan suaminya untuk tetap bercerai.\n" +
                        "\n" +
                        "Dengan perasaan tidak menentu, suami istri itu menyampaikan rencana perceraian kepada orang tua mereka. Meskipun orang tua mereka tidak setuju, tapi tampaknya keputusan bulat sudah diambil si suami. Setelah berbincang-bincang cukup lama dan alot, kedua orang tua pasangan itu dengan berat hati menyetujui perceraian tersebut. Tetapi, mereka mengajukan syarat, yakni agar perceraian pasangan suami istri itu diselenggarakan dalam sebuah sebuah pesta yang sama besarnya seperti pesta saat mereka menikah dulu.\n" +
                        "\n" +
                        "Agar tidak mengecewakan kedua orang tuanya, maka persyaratan mengadakan pesta perceraian itu pun disetujui. Beberapa hari kemudian, pesta diselenggarakan. Sungguh, itu merupakan pesta yang tidak membahagiakan bagi siapa saja yang hadir dalam pesta itu. Si suami tampak tertekan dan terus meminum arak sampai mabuk dan sempoyongan. Sementara sang istri tampak terus melamun dan sesekali mengusap air matanya di pipinya. Di sela mabuknya si suami berkata lantang, “Istriku, saat kau pergi nanti. semua barang berharga atau apapun yang kamu suka dan kamu sayangi, Ambillah dan Bawalah !!“. Setelah berkata seperti itu, tak lama kemudian ia semakin mabuk dan akhirnya tak sadarkan diri.\n" +
                        "\n" +
                        "Keesokan harinya, setelah pesta usai, si suami terbangun dari tidur dengan kepala berdenyut-denyut. Dia merasa tidak mengenali keadaan disekelilingnya selain sosok yang sudah dikenalnya bertahun-tahun yaitu sang istri yang ia cintai. Maka, dia pun bertanya “Ada dimakah aku ? Kenapa ini bukan di kamar kita ? Apakah aku masih mabuk dan bermimpi ? tolong jelaskan.”\n" +
                        "\n" +
                        "Si istri menatap penuh cinta pada suaminya dengan mata berkaca-kaca dan menjawab, “Suamiku, ini karena dirumah orang tuaku. Kemaren kau bilang didepan semua orang bahwa engkau berkata kepadaku, bahwa aku boleh membawa apa saja yang aku mau dan aku sayangi. Di dunia ini tidak ada satu barang yang berharga dan aku cintai dengan sepenuh hati selain kamu. karena itu kamu sekarang kubawa serta ke rumah orang tuaku. Ingat, kamu sudah berjanji dalam pesta itu.”\n" +
                        "\n" +
                        "Dengan perasaan terkejut setelah sesaat tersadar, si suami bangun dan memeluk istrinya, “Maafkan aku Istriku, aku sungguh bodoh dan tidak menyadari bahwa dalamnya cintamu padaku. Walaupun aku telah menyakitimu, dan berniat menceraikanmu, tetapi engkau masih mau membawa serta diriku bersamamu dalam keadaan apapun“.\n" +
                        "\n" +
                        "Akhirnya kedua suami istri ini ini berpelukan dan saling bertangisan. Mereka akhirnya mengikat janji akan tetap saling mencintai hingga ajal memisahkannya\n",
                R.drawable.ketulusan);
        datas2.add(data2);

        data2 = new Data("Malaikat dan Pengusaha",
                "Seorang pengusaha sukses jatuh di kamar mandi dan akhirnya stroke, sudah 7 malam dirawat di RS di ruang ICU. Di saat orang-orang terlelap dalam mimpi malam, dalam dunia roh seorang Malaikat menghampiri si pengusaha yang terbaring tak berdaya. Malaikat memulai pembicaraan, \"Kalau dalam waktu 24 jam ada 50 orang berdoa buat kesembuhanmu, maka kau akan hidup dan sebaliknya jika dalam 24 jam jumlah yang aku tetapkan belum terpenuhi, itu artinya kau akan meninggal dunia!\"\n" +
                        "\n" +
                        "\"Kalau hanya mencari 50 orang, itu mah gampang ...\" kata si pengusaha ini dengan yakinnya.\n" +
                        "\n" +
                        "Setelah itu Malaikat pun pergi dan berjanji akan datang 1 jam sebelum batas waktu yang sudah disepakati.\n" +
                        "\n" +
                        "Tepat pukul 23:00, Malaikat kembali mengunjunginya; dengan antusiasnya si pengusaha bertanya, \"Apakah besok pagi aku sudah pulih? Pastilah banyak yang berdoa buat aku, jumlah karyawan yang aku punya lebih dari 2000 orang, jadi kalau hanya mencari 50 orang yang berdoa pasti bukan persoalan yang sulit.\"\n" +
                        "\n" +
                        "Dengan lembut si Malaikat berkata, \"aku sudah berkeliling mencari suara hati yang berdoa buatmu tapi sampai saat ini baru 3 orang yang berdoa buatmu, sementara waktumu tinggal 60 menit lagi, rasanya mustahil kalau dalam waktu dekat ini ada 50 orang yang berdoa buat kesembuhanmu.\"\n" +
                        "\n" +
                        "Tanpa menunggu reaksi dari si pengusaha, si Malaikat menunjukkan layar besar berupa TV siapa 3 orang yang berdoa buat kesembuhannya. Di layar itu terlihat wajah duka dari sang istri, di sebelahnya ada 2 orang anak kecil, putra-putrinya yang berdoa dengan khusuk dan tampak ada tetesan air mata di pipi mereka.\n" +
                        "\n" +
                        "Kata Malaikat, \"Aku akan memberitahukanmu, kenapa Tuhan rindu memberikanmu kesempatan kedua - itu karena doa istrimu yang tidak putus-putus berharap akan kesembuhanmu.\"\n" +
                        "\n" +
                        "Kembali terlihat di mana si istri sedang berdoa jam 2:00 subuh, \"Tuhan, aku tahu kalau selama hidupnya suamiku bukanlah suami atau ayah yang baik! Aku tahu dia sudah mengkhianati pernikahan kami, aku tahu dia tidak jujur dalam bisnisnya, dan kalaupun dia memberikan sumbangan, itu hanya untuk popularitas saja untuk menutupi perbuatannya yang tidak benar di hadapanMu. Tapi Tuhan, tolong pandang anak-anak yang telah Engkau titipkan pada kami, mereka masih membutuhkan seorang ayah dan hamba tidak mampu membesarkan mereka seorang diri.\" Dan setelah itu istrinya berhenti berkata-kata tapi air matanya semakin deras mengalir di pipinya yang kelihatan tirus karena kurang istirahat.\n" +
                        "\n" +
                        "Melihat peristiwa itu, tanpa terasa, air mata mengalir di pipi pengusaha ini . . . timbul penyesalan bahwa selama ini dia bukanlah suami yang baik dan ayah yang menjadi contoh bagi anak-anaknya, dan malam ini dia baru menyadari betapa besar cinta istri dan anak-anak padanya.\n" +
                        "\n" +
                        "Waktu terus bergulir, waktu yang dia miliki hanya 10 menit lagi, melihat waktu yang makin sempit semakin menangislah si pengusaha ini, penyesalan yang luar biasa tapi waktunya sudah terlambat! Tidak mungkin dalam waktu 10 menit ada yang berdoa 47 orang!\n" +
                        "\n" +
                        "Dengan setengah bergumam dia bertanya, \"Apakah di antara karyawanku, kerabatku, teman bisnisku, teman organisasiku tidak ada yang berdoa buatku?\"\n" +
                        "\n" +
                        "Jawab si Malaikat, \"Ada beberapa yang berdoa buatmu tapi mereka tidak tulus, bahkan ada yang mensyukuri penyakit yang kau derita saat ini, itu semua karena selama ini kamu arogan, egois dan bukanlah atasan yang baik, bahkan kau tega memecat karyawan yang tidak bersalah.\"\n" +
                        "\n" +
                        "Si pengusaha tertunduk lemah, dan pasrah kalau malam ini adalah malam yang terakhir buat dia, tapi dia minta waktu sesaat untuk melihat anak dan si istri yang setia menjaganya sepanjang malam.\n" +
                        "\n" +
                        "Air matanya tambah deras, ketika melihat anaknya yang sulung tertidur di kursi rumah sakit dan si istri yang kelihatan lelah juga tertidur di kursi sambil memangku si bungsu.\n" +
                        "\n" +
                        "Ketika waktu menunjukkan pukul 24:00, tiba-tiba si Malaikat berkata, \"Tuhan melihat air matamu dan penyesalanmu!! Kau tidak jadi meninggal, karena ada 47 orang yang berdoa buatmu tepat jam 24:00.\"\n" +
                        "\n" +
                        "Dengan terheran-heran dan tidak percaya,si pengusaha bertanya siapakah yang 47 orang itu. Sambil tersenyum si Malaikat menunjukkan suatu tempat yang pernah dia kunjungi bulan lalu.\n" +
                        "\n" +
                        "\"Bukankah itu Panti Asuhan?\" kata si pengusaha pelan.\n" +
                        "\n" +
                        "\"Benar anakku, kau pernah memberi bantuan bagi mereka beberapa bulan yang lalu, walau aku tahu tujuanmu saat itu hanya untuk mencari popularitas saja dan untuk menarik perhatian pemerintah dan investor luar negeri.\"\n" +
                        "\n" +
                        "\"Tadi pagi, salah seorang anak panti asuhan tersebut membaca di koran kalau seorang pengusaha terkena stroke dan sudah 7 hari di ICU, setelah melihat gambar di koran dan yakin kalau pria yang sedang koma adalah kamu, pria yang pernah menolong mereka dan akhirnya anak-anak panti asuhan sepakat berdoa buat kesembuhanmu.\"\n" +
                        "\n" +
                        "Sahabatku, cerita ini hanyalah sebuah gambaran agar kita lebih instropeksi diri. Saya membayangkan ketika diri saya mati nanti, apakah orang disekeliling saya akan kehilangan, atau sebaliknya mereka mengabaikan atas kematian saya, atau yang paling parah apakah mereka bersyukur malah?\n" +
                        "\n" +
                        "Ah.. mumpung kita masih diberi umur, lakukanlah yang terbaik untuk orang2 disekitar kita, kaena sebaik-baik manusia adalah yang bermanfaat bagi manusia yang lainnya.\n" +
                        "\n" +
                        "Dan satu lagi, janganlah engkau meremehkan sedekah, sesuai cerita diatas, justru sedekahnya yang menyelamatkan pengusaha tersebut\n",
                R.drawable.malaikat);
        datas2.add(data2);

        data2 = new Data("Empat Lilin",
                "Ada empat buah lilin yang menyala dengan terang. Suasana begitu hening hingga terdengarlah percakapan mereka. Lilin pertama berkata, “Aku adalah kedamaian. Tidak ada seorang pun yang mampu menjaga cahayaku di segala kondisi. Aku yakin bahwa aku harus pergi dan aku merasa tidak mempunyai alasan untuk tetap tinggal.” Lilin itu pun memadamkan cahayanya dengan menguranginya secara berangsur – angsur hingga cahayanya benar – benar lenyap.\n" +
                        "\n" +
                        "Lilin kedua berkata, “Aku adalah iman.” Satu hembusan angin pun bertiup dan memadamkan cahayanya secara total.\n" +
                        "\n" +
                        "Ketika gilirannya tiba, dengan sedih lilin ketiga berkata, “Aku adalah kasih sayang. Aku tidak mempunyai kemampuan untuk terus ada. Tidak ada lagi seseorang yang mempedulikan aku, sedang orang – orang tidak menghormati nilai – nilaiku dan mereka melupakan kasih sayang orang yang paling dekat dengan mereka.”\n" +
                        "\n" +
                        "Tiba – tiba, ada seorang anak kecil masuk ke kamar itu dan menyaksikan apa yang terjadi dengan ketiga lilin itu. Anak kecil itu pun mulai menangis. Saat itulah lilin keempat angkat bicara dan berkata, “Jangan takut, hai anakku. Selama aku masih ada, kita mampu menyalakan kembali tiga lilin itu. Aku adalah harapan.”\n" +
                        "\n" +
                        "Dengan mata yang berseri – seri, anak kecil itu meraih lilin harapan dan mulai menyalakan ketiga lilin lainnya.\n" +
                        "Sinar harapan tidak boleh padam dari kehidupan kita. Dengan itu, manusia mampu menjaga iman, kedamaian, dan kasih sayang.\n" +
                        "\n" +
                        "Sesungguhnya perumpamaan optimisme dan harapan adalah seperti kelemahan dan keputusasaan, yakni : bisa di pelajari.\n" +
                        "Hinaan Membawa Berkah\n" +
                        "Suatu hari, anak muda ini mengantar penuh muatan berisi puluhan buku ke kantor berlantai 7 di suatu perguruan tinggi ; ketika dia memanggul buku-buku tersebut menunggu di lift, seorang satpam yang berusia 50-an menghampirinya dan berkata : “Lift ini untuk profesor dan dosen, lainnya tidak diperkenankan memakai lift ini, kau harus lewat tangga!”\n" +
                        "\n" +
                        "Anak muda memberian penjelasan pada satpam itu :\n" +
                        "\n" +
                        "“Saya hanya ingin mengantar buku semobil ini ke kantor lantai 7, ini kan buku pesanan kampus ini !”\n" +
                        "\n" +
                        "Namun, dengan beringas satpam itu berkata :\n" +
                        "\n" +
                        "“Saya bilang tidak boleh ya tidak boleh, kau bukan profesor atau pun dosen, tidak boleh menggunakan lift ini!\n" +
                        "\n" +
                        "Kedua orang itu berdebat cukup lama di depan pintu lift, tapi, satpam tetap bersikeras tidak mau mengalah. Dalam benak anak muda itu berpikir, jika hendak mengangkut habis buku semobil penuh ini, paling tidak harus bolak-balik 20 kali lebih ke lantai 7, ini akan sangat melelahkan!\n" +
                        "\n" +
                        "Kemudian, anak muda itu tidak dapat menahan lagi satpam yang menyusahkan ini, lantas begitu pikirannya terlintas, ia memindahkan tumpukan buku-buku itu ke sudut aula, kemudian pergi begitu saja.\n" +
                        "\n" +
                        "Setelah itu, anak muda menjelaskan peristiwa yang dialaminya kepada bos, dan bos bisa memakluminya,sekaligus juga mengajukan surat pengunduran diri pada bosnya, dan segera setelah itu ia pergi ke toko buku membeli bahan pelajaran sekolah SMU dan buku referensi, sambil meneteskan air mata ia bersumpah, saya harus bekerja keras, harus bisa lulus masuk ke perguruan tinggi, saya tidak akan membiarkan dilecehkan orang lagi.\n" +
                        "\n" +
                        "Selama 6 bulan menjelang ujian, anak muda ini belajar selama 14 jam setiap hari, sebab ia sadar, waktunya sudah tidak banyak, ia tidak bisa lagi mundur, saat ia bermalas-malasan, dalam benaknya selalu terbayang akan hinaan security yang tidak mngizinkannya memakai lift, membayangkan diskriminasi ini, ia segera memacu semangatnya, dan melipatkan gandakan kerja kerasnya.\n" +
                        "\n" +
                        "Belakangan, anak muda ini akhirnya berhasil lulus masuk ke salah satu lembaga ilmu kedokteran. Dan kini, selama 20 tahun lebih telah berlalu, sang anak muda akhirnya berhasil menjadi seorang dokter klinik.\n" +
                        "\n" +
                        "Sang dokter merenung sejenak, ketika itu, jika bukan karena security yang sengaja mempersulitya, bagaimana mungkin ia menyeka air matanya dari hinaan itu, dan berdiri dengan berani ?\n" +
                        "\n" +
                        "Dia telah berhutang budi pada security yang menghinanya.\n",
                R.drawable.lilin);
        datas2.add(data2);

        return datas2;
    }

    public ArrayList<Data> getLaranganList() {
        ArrayList<Data> datas3 = new ArrayList<>();
        Data data3 = new Data("Larangan Menyambung Rambut",
                "“Dari Abu Hurairah, bahwa seorang perempuan datang kepada Nabi saw,, lalu katanya : “ Wahai Rasulullah, sesungguhnya anak perempuanku akan menjadi pengantin, sedang rambutnya telah rusak karena penyakit campak, maka bolehkan aku menyambungnya ? Nabi saw. Menjawab : “ Allah melaknati orang yang menyambung rambut, orang yang minta disambung rambutnya, orang yang membuat tatoo dan orang yang minta di tattoo.”(HR. Abu Dauwud & Ahmad)\n" +
                        "Dari hadis ini bukankah sudah sangat jelas yang bahwa Rasulullah saw. Tidak menyukai orang – orang yang semacam ini. Jika Rasulullah tidak suka kepada kita apalagi Allah SWT. Na’uzubillah semoga kita tidak termasuk salah satu dari golongan ini ya. Kita sebagai ummatnya sudah semestinya kita mengikuti  jejaknya, begitu juga warisnya, itulah para sahabat dan ‘ulama.\n" +
                        "Dikatakan di dalam Kitab Nailul Authaar :\n" +
                        "Menyambung rambut itu diharamkan karena laknat itu tidak dikenakan pada yang tidak diharamkan. Kata Nawawi: inilah kenyataan yang dipilih. Dia berkata : sahabat-sahabat kami telah menjelaskannya,kata mereka: Bila perempuan menyambung rambutnya dengan rambut manusia maka hal itu jelas haramnya, dan tidak di perselisihkan lagi; baik yang disambungkan itu rambut dari lelaki, perempuan, rambut muhrimnya, rambut suaminya atau rambut yang lainnya, tanpa diperselisihkan lagi karena keumuman dalil-dalil tersebut.\n" +
                        "Bila seorang perempuan menyambung rambutnya dengan rambut manusia yang sudah mati atau rambut binatang maka hukumnya haram pula karena hadis diatas, dan karena dia secara sengaja dia membawa najis kedalam shalatnya dan yang bukan shalat. Kedua hal ini sama saja hukumnya baik bagi yang sudah menikah atau tidak, baik laki-laki ataupun perempuan.\n" +
                        "\n" +
                        "Adapun rambut yang suci yang bukan dari manusia, bila perempuan itu tidak mempunyai suami atau tuan maka haram hukumnya. Bila sebaliknya ini ada tiga pendapat; Pertama, tidak di perbolehkan karena zahirnya hadist-hadist diatas. Kedua, diperbolehkan. Ketiga, bila perempuan itu menyambungnya atas seizin suami atau tuannya, maka hal itu diperbolahkan, bila tidak diizinkan, haram hukumnya. Pendapat ketiga ini adalah pendapat yang paling sahih bagi mereka.\n",
                R.drawable.enam);
        datas3.add(data3);

        data3 = new Data("Larangan Merubah Bentuk Tubuh (sulam alis, sulam bibir, tato, tanam benang)",
                "Sulam alir sebagaimana sulam bibir hukumnya haram dalam Islam berdasarkan pada hadits berikut: \n" +
                        "Hadits riwayat Muslim #3966 dan riwayat Bukhari #5604:\n" +
                        "\"Allah melaknat wanita-wanita yang mentato dan yang meminta untuk ditatokan, yang mencukur (menipiskan) alis dan yang meminta dicukur, yang mengikir gigi supaya kelihatan cantik dan merubah ciptaan Allah.\"\n" +
                        "\n" +
                        "Dalam menjelaskan hadits di atas, Imam Nawawi dalam kitab Syarah Muslim 13/107 menyatakan: \"Al-Wasyimah\" adalah wanita yang mentato. Yaitu melukis punggung telapak tangan, pergelangan tangan, bibir atau anggota tubuh lainnya dengan jarum atau sejenisnya hingga mengeluarkan darah lalu dibubuhi dengan tinta untuk diwarnai. Perbuatan tersebut haram hukumnya bagi yang mentato ataupun yang minta ditatokan.\"\n" +
                        "\n" +
                        "Ibnu Hajar al-Asqalani dalam Fathul Bari Syarah Shahih Bukhari menyatakan bahwa perempuan tidak boleh merubah sesuatu dari bentuk asal yang telah diciptakan Allah, baik menambah atau mengurangi agar kelihatan bagus. Seperti, seorang perempuan yang alisnya berdempetan, kemudian ia menghilangkan (bulu alis) yang ada di antara keduanya, agar kelihatan cantik atau sebaliknya (kelihatan jelek dengan berdempetannya).\n" +
                        "\n" +
                        "Sulam alis dan sulam bibir sama-sama memakai sistem pewarnaan dan merubah ciptaan Allah yang diharamkan secara eksplisit pada hadits di atas (Lihat juga firman Allah dalam QS An-Nisa 4:119). Sedangkan tanam benang juga haram karena merubah ciptaan Allah. Namun, khusus untuk pewarnaan kulit (seperti sulam alis atau sulam bibir), Imam Nawawi menyatakan boleh bagi perempuan yang bersuami asalkan mendapat ijin dari suaminya, sedang yang belum bersuami haram secara mutlak.\n" +
                        "\n" +
                        "Dalam menafsiri hadits di atas Imam Nawawi dalam Syarah Muslim 1/287 menyatakan:\n" +
                        "Islam memerintahkan seorang muslim untuk mensyukuri fisik yang ada tanpa merubahnya. Kalau ingin merubah, maka rubahlah mental dan akhlak kita menjadi lebih baik karena di situ letak daya tarik hakiki dari seorang wanita.\n" +
                        "\n",
                R.drawable.tujuh);
        datas3.add(data3);

        data3 = new Data("Larangan Ghibah",
                "Ghibah atau menggunjing adalah menyebutkan sesuatu  yang terdapat pada saudaranya ketika ia tidak hadir dengan sesuatu yang benar tetapi tidak disukainya, seperti menggambarkannya dengan apa yang dianggap sebagai kekurangan menurut umum untuk meremehkan dan menjelekkan. Maksud saudaranya di sini adalah sesama muslim. Termasuk sebagai ghibah adalah menarik perhatian seseorang terhadap sesuatu dimana orang yang dibicarakan tidak suka untuk dikenali seperti itu.\n" +
                        "\n" +
                        "Dalam al-Qur’an surah al-Hujurat (49) ayat 12 sebagaimana tercantum di atas, Allah melarang ber-ghibah dan menggambarkan pelakunya sebagai pemakan bangkai saudaranya. Di samping itu cukup banyak hadits yang juga melarangnya, antara lain:\n" +
                        " “Wahai orang-orang yang beriman! Jauhilah kebanyakan prasangka karena sesungguhnya sebagian prasangka adalah dosa. Janganlah kamu sekalian mencari-cari kesalahan orang lain dan janganlah kamu sekalian berghibah( menggunjing) satu sama lain. Adakah seseorang di antara kamu sekalian yang suka makan daging saudaranya yang sudah mati? Tentu kamu merasa jijik kepadanya. Bertakwalah kepada Allah, sesungguhnya Allah maha penerima taubat lagi maha penyayang.” [QS: 49 (al Hujurat) ayat 12.]\n" +
                        "\n" +
                        "Pada umumnya manusia tidak suka kekurangan atau hal-hal negatif yang ada pada dirinya menjadi bahan perbincangan publik. An Nawawi memberikan penjelasan tentang hal-hal yang disebut antara lain: keadaan tubuhnya, agamanya, dunianya, dirinya, akhlaknya, hartanya, anaknya, orang tuanya, isterinya, pembantunya, pakaiannya, gerak-geriknya, raut mukanya, atau hal-hal lain yang berhubungan dengannya.\n" +
                        "Perbincangan pada obyek-obyek tersebut menjadi ghibah bila orang yang diperbicangkan merasa tidak suka.  Perbuatan ghibah bisa dilakukan melalui pembicaraan lisan, tulisan, isyarat, atau dengan bahasa tubuh.\n" +
                        "\n" +
                        "Ghibah dengan pembicaraan lisan bisa terjadi saat berbicara dengan seseorang, sekelompok orang, atau dalam majlis. Ghibah dengan tulisan bisa dilakukan dalam bentuk surat kepada seseorang, tulisan publikasi dalam koran, tabloid, majalah, buku, website, facebook, twitter,  brosur, dll. Ghibah melalui bahasa tubuh bisa dilakukan dengan isyarat, ekspresi wajah, gerakan tubuh tertentu, atau menirukan tingkah laku dan gerak tertentu dari orang yang dipergunjingkan dengan maksud mengolok-olok.\n" +
                        "Dalam kehidupan masyarakat saat ini, ghibah juga dilakukan dengan dukungan media masa sehingga mempunyai efek yang sangat luas. Kita menyaksikan banyak stasiun radio dan televisi menyajikan acara ghibah yang dikemas dengan cara yang menarik, mendapat apresiasi luas dari masyarakat yang dibuktikan dengan rating jumlah penonton yang banyak. Kita juga mudah mendapatkan koran, tabloid, majalah, brosur yang tulisan-tulisannya mengandung ghibah mempunyai tiras besar,  yang berarti banyak dibeli dan dibaca masyarakat. Ghibah kini telah didukung oleh teknologi informasi lainnya yang canggih seperti handphone,  telekonferen, audiostreaming, videostreaming, jejaring sosial facebook, twitter,  dll.\n" +
                        "Bagaimana halnya dengan orang yang hanya mendengarkan orang lain ber-ghibah? Mau mendengarnya berarti membiarkan orang lain berbuat mungkar, yakni melanggar larangan Allah ber-ghibah. Rasulullah memerintahkan kita bila melihat kemungkaran hendaknya merubah dengan kekuasaan, lisan, atau hatinya. Yang paling utama dengan kekuasaan. Bila hanya mampu dengan hati, imannya dalam  kondisi yang selemah-lemahnya.\n",
                R.drawable.delapan);
        datas3.add(data3);

        data3 = new Data("Larangan Menolak Ajakan Suami",
                "Berkhidmat kepada suami dengan melayaninya dalam segala kebutuhan-kebutuhannya adalah diantara tugas seorang istri. Bukan sebaliknya, istri yang malah dilayani oleh suami. Hal ini didukung oleh firman Allah, “Dan laki-laki itu adalah pemimpin bagi wanita.” (QS. An Nisa [4]: 34)\n" +
                        "\n" +
                        "Dalam hak berhubungan suami-istri, jika suami mengajaknya untuk berhubungan, maka istri tidak boleh menolaknya.\n" +
                        "“Jika seorang suami memanggil istrinya ke tempat tidur, kemudian si istri tidak mendatanginya, dan suami tidur dalam keadaan marah, maka para malaikat akan melaknatnya sampai pagi.” (HR Bukhari Muslim)\n" +
                        "\n" +
                        "Rasulullah shallallahu ‘alaihi wa sallam bersabda, “Tidak boleh bagi seorang perempuan berpuasa sementara suaminya ada di rumah kecuali dengan izinnya. Dan tidak boleh baginya meminta izin di rumahnya kecuali dengan izinnya.” (HR Bukhari Muslim)\n" +
                        "\n",
                R.drawable.sembilan);
        datas3.add(data3);

        data3 = new Data("Larangan Mengumbar Aurat",
                "Rasulullah bersabda :\n" +
                        "“wahai Ali pada malam mi’raj ketika aku pergi ke langit ,aku melihat wanita–wanita umatku dalam azab dan siksa yang sangat pedih sehingga aku tidak mengenali mereka. Oleh karena itu, sejak aku melihat pedihnya azab dan siksa mereka, aku menangis. \n" +
                        "Aku melihat wanita yang digantung dengan rambutnya dan otak kepalanya mendidih. Rasulullah saw  bersabda: “Wanita yang digantung dengan rambutnya dan otak kepalanya mendidih adalah wanita  yang tidak mau menutupi rambutnya dari pandangan laki-laki yang bukan mahram. Sepenggal cerita Ali ra diatas dari 11 sabda Rosullullah saw. mengenai wanita yang masuk neraka nererangkan dengan jelas bahwasanya seorang wanita akan masuk neraka jika tidak menutupi rambutnya atau memakai jilbab (Hijab) Mungkin Kaum wanita sekarang menyangka bahwa tidak memakai jilbab adalah dosa kecil,bahkan ada yang bilang lebih baik tak memakai jelbab dari pada memakai juga tak bisa menjaga kelakuannya\" Kaum wanita menganggap yang terpenting hatinya dan bisa menjaga prilaku dan mengerjakan sholat, puasa, zakat dan haji yang mereka lakukan tanpa memikirkan untuk menutupi auratnya.\n" +
                        "Al-Qur'an surat Al-Maidah ayat 5 baris terakhir yang artinya sbb: \n" +
                        "Barang siapa yang mengingkari hukum-hukum syariat Islam sesudah beriman, maka hapuslah pahala amalnya bahkan di akhirat dia termasuk orang-orang yang merugi”. Sebagaimana telah diterangkan dimuka, memakai jilbab bagi kaum wanita adalah hukum syariat Islam yang digariskan Allah dalam surat An-Nur ayat 59. Jadi kaum wanita yang tak memakainya, mereka telah mengingkari hukum syariat Islam dan bagi mereka berlaku ketentuan Allah yang tak bisa ditawar lagi, yaitu hapus pahala shalat, puasa, zakat dan haji mereka.\n" +
                        "Ingatlah, azab untuk kita yg sengaja membiarkan aurat kita dilihat oleh lelaki bukan mahram adalah dosa yang besar dan dapat membawa ke dalam Api Neraka Allah SWT.\n",
                R.drawable.sepuluh);
        datas3.add(data3);

        data3 = new Data("Larangan Dandan Berlebih dan Memakai Parfum Berlebih",
                "Dalam agama Islam sangat dilarang melakukan hal yang berlebihan, termasuk salah satunya saat berdandan.Tidak bisa dipungkiri setiap wanita tentu saja ingin tampil cantik, tak terkecuali dengan seorang muslimah. Salah satu cara agar tampil cantik adalah dengan berdandan atau berhias. Namun tidak semua cara berdandan sekarang ini dibenarkan dalam islam. Wanita muslimah wajahnya akan nampak bersinar hanya dengan air wudlu yang digunakan untuk beribadah kepada Allah SWT.\n" +
                        "Meskipun sudah menutupi aurat secara penuh, apabila seorang muslimah berdandan tapi masih mengundang syahwat maka haram baginya untuk berdandan seperti itu. Lalu bagaimana dandan yang yang mengundang syahwat itu? Misalnya memakai pakaian yang tipis sehingga nampak transparan atau mengenakan baju menampakkan lekuk tubuh. Selain itu mengenakan make up juga dapat mengundang syahwat, misalnya menggunakan lipstik tebal dengan warna mencolok sehingga membuat bibir nampak seksi.\n" +
                        "Rasulullah bersabda :\n" +
                        "“Wanita yang berpakaian tetapi telanjang, yang berjalan berlenggak-lenggok guna membuat manusia memandangnya, mereka tidak akan masuk surga dan tidak akan mendapati aromanya. Padahal aroma Surga bisa dicium dari jarak 500 tahun.” (HR. Malik)\n" +
                        "Meskipun sudah menutupi aurat secara penuh, namun jika seorang muslimah tampil tomboi seperti halnya seorang laki-laki maka hal tersebut juga tidak diperbolehkan. “Rasulullah melaknat laki-laki yang berpakaian wanita dan wanita yang berpakaian laki-laki” (HR. Ahmad)\n" +
                        "Sering kita jumpai perempuan ketika berada di jalan menggunakan parfum dengan bau yang sangat menyengat. Bahkan dengan jarak beberapa meter bau parfum tersebut sudah tercium. Sebenarnya muslimah tidak dilaran menggunakan parfum, namun hanya boleh digunakan di rumah untuk menyenangkan suami.\n" +
                        "Yang membuatnya dilarang adalah ketika menggunakan parfum di luar rumah dan tercium oleh lelaki yang bukan mahramnya sehingga dapat menimbulkan syahwat. Bahkan Rosulullah menyebut wanita seperti itu sama saja dengan berzina. “Wanita mana saja yang memakai parfum lalu melewati suatu kaum supaya mereka mencium bau parfum itu maka perempuan itu telah berzina” (HR. Ahmad)\n" +
                        "\n" +
                        "\n",
                R.drawable.sebelas);
        datas3.add(data3);


        return datas3;
    }

    @Override
    public void doClick(int pos) {
        int id = getIntent().getIntExtra(MainActivity.ID, 0);

        if (id == 1) {
            mDataAdapter = new DataAdapter(this, datas1);
            datas = datas1;
        } else if (id == 2) {
            mDataAdapter = new DataAdapter(this, datas2);
            datas = datas2;
        } else if (id == 3) {
            mDataAdapter = new DataAdapter(this, datas3);
            datas = datas3;
        }

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(INTENT_DETAIL, datas.get(pos));
        startActivity(intent);
    }
}