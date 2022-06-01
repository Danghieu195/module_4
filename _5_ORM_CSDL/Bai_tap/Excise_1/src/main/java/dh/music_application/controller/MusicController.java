package dh.music_application.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import dh.music_application.model.Music;
import dh.music_application.service.IMusicService;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "")
    public String list(Model model) {
        List<Music> musics = this.iMusicService.findAll();
        model.addAttribute("musics",musics);

        return "list";
    }

}
