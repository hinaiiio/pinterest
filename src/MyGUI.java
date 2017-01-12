import com.fasterxml.jackson.core.type.TypeReference;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

/**
 * Created by hina on 2017/01/11.
 */
public class MyGUI extends JFrame implements ActionListener {

    private JPanel pane;
    private JButton ohituji;
    private JButton oushi;
    private JButton futago;
    private JButton kani;
    private JButton shishi;
    private JButton otome;
    private JButton tenbin;
    private JButton sasori;
    private JButton ite;
    private JButton yagi;
    private JButton mizugame;
    private JButton uo;

    private JScrollPane scrollPane;
    private JPanel imagePane;
    private ImageIcon icon1, icon2, icon3;
    private JLabel label1, label2, label3, infoLabel;


    String stringurl = "";
    URL url;

    HoroscopeList horoscopeList;
    int number;

    public MyGUI(HoroscopeList horoscopeList) {
        super("Today's Your Color");
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 400, 300 );
        pane = new JPanel();

        this.horoscopeList = horoscopeList;

        //component
        ohituji = new JButton("おひつじ");ohituji.addActionListener(this);
        oushi = new JButton("おうし");oushi.addActionListener(this);
        futago = new JButton("ふたご");futago.addActionListener(this);
        kani = new JButton("かに");kani.addActionListener(this);
        shishi = new JButton("しし");shishi.addActionListener(this);
        otome = new JButton("おとめ");otome.addActionListener(this);
        tenbin = new JButton("てんびん");tenbin.addActionListener(this);
        sasori = new JButton("さそり");sasori.addActionListener(this);
        ite = new JButton("いて");ite.addActionListener(this);
        yagi = new JButton("やぎ");yagi.addActionListener(this);
        mizugame = new JButton("みずがめ");mizugame.addActionListener(this);
        uo = new JButton("うお");uo.addActionListener(this);

        infoLabel = new JLabel("今日のあなたのラッキーカラーに合わせたコーディネイトを表示します");


//        try{
//            stringurl = "http://www.oyakudachibook.com/wp-content/uploads/2014/01/44cf4d71bf948536b4369c35badd7391.png";
//            url = new URL(stringurl);
//        }catch(MalformedURLException E){
//            E.printStackTrace();
//        }
        icon1 = new ImageIcon();
        icon2 = new ImageIcon();
        icon3 = new ImageIcon();
        label1 = new JLabel(icon1);
        label2 = new JLabel(icon2);
        label3 = new JLabel(icon3);


        //layout
        getContentPane().setLayout(new BorderLayout());

        pane.setLayout(new GridLayout(3, 4));
        pane.add(ohituji);
        pane.add(oushi);
        pane.add(futago);
        pane.add(kani);
        pane.add(shishi);
        pane.add(otome);
        pane.add(tenbin);
        pane.add(sasori);
        pane.add(ite);
        pane.add(yagi);
        pane.add(mizugame);
        pane.add(uo);
        add(pane, BorderLayout.NORTH);

        imagePane = new JPanel(new BorderLayout());
        scrollPane = new JScrollPane(label1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.add(label2);
        scrollPane.add(label3);
        imagePane.add(scrollPane);
        add(imagePane, BorderLayout.CENTER);

        add(infoLabel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(ohituji.equals(e.getSource())){
            try { switchImg(0); } catch (IOException E) { System.out.println(E); }
        }
        if(oushi.equals(e.getSource())) {
            try { switchImg(1); } catch (IOException E) { System.out.println(E); }
        }
        if(futago.equals(e.getSource())){
            try { switchImg(2); } catch (IOException E) { System.out.println(E); }
        }
        if(kani.equals(e.getSource())){
            try { switchImg(3); } catch (IOException E) { System.out.println(E); }
        }
        if(shishi.equals(e.getSource())){
            try { switchImg(4); } catch (IOException E) { System.out.println(E); }
        }
        if(otome.equals(e.getSource())){
            try { switchImg(5); } catch (IOException E) { System.out.println(E); }
        }
        if(tenbin.equals(e.getSource())){
            try { switchImg(6); } catch (IOException E) { System.out.println(E); }
        }
        if(sasori.equals(e.getSource())){
            try { switchImg(7); } catch (IOException E) { System.out.println(E); }
        }
        if(ite.equals(e.getSource())){
            try { switchImg(8); } catch (IOException E) { System.out.println(E); }
        }
        if(yagi.equals(e.getSource())){
            try { switchImg(9); } catch (IOException E) { System.out.println(E); }
        }
        if(mizugame.equals(e.getSource())){
            try { switchImg(10); } catch (IOException E) { System.out.println(E); }
        }
        if(uo.equals(e.getSource())){
            try { switchImg(11); } catch (IOException E) { System.out.println(E); }
        }

    }

    private void switchImg(int number) throws IOException{
        String color = horoscopeList.getHoroscope().getDayInfo().get(number).getColor();
        GoogleImgList imgList = ImgSearch.getImage(color);
        infoLabel.setText("あなたの今日のラッキーカラーは 『" + color + "』 です！");

            try {
                //Load another image from internet.
                stringurl = imgList.getItems().get(0).getLink();
                BufferedImage img = ImageIO.read(new URL(stringurl));
                icon1.setImage(img);
                label1.setIcon(icon1);
                System.out.println(stringurl);
//                stringurl = imgList.getItems().get(1).getLink();
//                img = ImageIO.read(new URL(stringurl));
//                icon2.setImage(img);
//                label2.setIcon(icon2);
//                System.out.println(stringurl);
//
//                stringurl = imgList.getItems().get(2).getLink();
//                img = ImageIO.read(new URL(stringurl));
//                icon3.setImage(img);
//                label3.setIcon(icon3);
//                System.out.println(stringurl);


            } catch (MalformedInputException E) {
                E.printStackTrace();
            } catch (IOException E) {
                E.printStackTrace();
                stringurl = imgList.getItems().get(1).getLink();
                BufferedImage img = ImageIO.read(new URL(stringurl));
                icon1.setImage(img);
                label1.setIcon(icon1);
            }

        repaint();

    }

    public static void main(String[] args) throws IOException {
        HoroscopeList horoscopeList = WebFortune.getFortune();
        MyGUI myGUI = new MyGUI(horoscopeList);

    }

}
