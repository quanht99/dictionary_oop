//import com.sun.speech.freetts.Voice;
//import com.sun.speech.freetts.VoiceManager;
//
//import javax.swing.*;
//
//public class TestTTS {
//    VoiceManager freettsVM;
//    Voice freettsVoice;
//
//    public TestTTS(String words){
//        freettsVM = VoiceManager.getInstance();
//
//        //freettsVoice = freettsVM.getVoice("mbrola_us1");
//
//        freettsVoice.allocate();
//        sayWords(words);
//    }
//
//    private void sayWords(String words) {
//        freettsVoice.speak(words);
//    }
//    public static void main(String[] args){
//        new TestTTS("Hello");
//    }
//}
//
