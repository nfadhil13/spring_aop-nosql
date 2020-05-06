package com.spring_disc.disc.disc.controller;

import com.spring_disc.disc.disc.model.DVD;
import com.spring_disc.disc.disc.model.Movie;
import com.spring_disc.disc.disc.model.TransactionLog;
import com.spring_disc.disc.disc.service.MovieService;
import com.spring_disc.disc.disc.service.TransactionLogService;
import org.apache.tomcat.jni.Local;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Controller
@RequestMapping("/moviepage")
public class MasterMovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value= "/{username}/list")
    public String listMovie(ModelMap params , @PathVariable String username){
        params.addAttribute("listMovie",movieService.getMovie());
        params.addAttribute("username",username);
        return "pages/Movie/MovieList";
    }

    @GetMapping("/{username}/form")
    public String formMovie(Movie movie , ModelMap params , @PathVariable String username){
        params.addAttribute("username",username);
        params.addAttribute("movie",movie);
        return "/pages/Movie/AddMovie";
    }

    @GetMapping("/{username}/edit/{id}")
    public String formEditMovie(Movie movie , ModelMap params ,@PathVariable("id") String id,
                                @PathVariable String username){
        params.addAttribute("username",username);
        params.addAttribute("movie",movieService.getMovieById(id));
        return "/pages/Movie/AddMovie";
    }

    @PostMapping("/{username}/submit")
    public String sumbitMovie(@ModelAttribute  Movie movie , @PathVariable String username){
        ObjectId id = new ObjectId();
        movie.setId(id.toString());
        List<DVD> dvdList = new ArrayList<>();
        for(int i=0 ;i<movie.getStock();i++){
            String idDVD = movie.getTitle().replace(" ","").concat(String.valueOf(i));
            idDVD = movie.getId().substring(0,2).concat(idDVD);
            DVD dvd = new DVD(idDVD,true,LocalDate.now(),LocalDate.now());
            dvdList.add(dvd);
        }
        movie.setDvdList(dvdList);
        movieService.addMovie(movie);
        return "redirect:/moviepage/"+username+"/list";
    }

    @GetMapping("/{username}/delete/{id}")
    public String deleteMovieById(@PathVariable("id") String id , @PathVariable("username") String username){
        movieService.deleteById(id);
        return "redirect:/moviepage/"+username+"/list";
    }

    @GetMapping("/{username}/detail/{id}")
    public String detailMovie(@PathVariable("id") String id, ModelMap params , RedirectAttributes redirectAttributes ,
                              @PathVariable("username") String username){
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isPresent()){
            params.addAttribute("movie" ,movieService.getMovieById(id).get());
            params.addAttribute("username",username);
            return "pages/Movie/MovieDetail";
        }
        redirectAttributes.addFlashAttribute("notAvailable" , "Terjadi Error Saat Membaca Data ");
        return "redirect:/moviepage/"+username+"/list";
    }
    @GetMapping("/{username}/rent/{id}/{code}")
    public String rentDVDForm(   TransactionLog transactionLog ,
                                 @PathVariable("id") String id ,
                                 @PathVariable("code") String code ,
                                 ModelMap params,
                                 RedirectAttributes redirectAttributes,
                                 @PathVariable("username") String username){
        try{
            Optional<Movie> movie = movieService.getMovieById(id);
            if(movie.isPresent()){
                transactionLog.setMovieCode(movie.get().getId());
                transactionLog.setMovieTitle(movie.get().getTitle());
                transactionLog.setCodeDVD(code);
                params.addAttribute("transactionLog",transactionLog);
                params.addAttribute("username",username);
                return "pages/Movie/RentMovie";
            }
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("notAvailable" , "Terjadi Error Saat Membaca Data ");
            return "redirect:/moviepage/"+username+"/list";
        }
        redirectAttributes.addFlashAttribute("notAvailable" , "Terjadi Error Saat Membaca Data ");
        return "redirect:/moviepage/"+username+"/list";
    }

    @PostMapping("{username}/rent/submit")
    public String submitRent(@ModelAttribute TransactionLog transactionLog ,
                             RedirectAttributes redirectAttributes , @PathVariable("username") String username){
        String dvdCode = transactionLog.getCodeDVD();
        int rentDays = transactionLog.getRentDays();
        Optional<Movie> movie = movieService.getMovieById(transactionLog.getMovieCode());
        if(movie.isPresent()){
            for(int i=0;i<movie.get().getDvdList().size();i++){
                if(movie.get().getDvdList().get(i).getCode().equals(dvdCode)){
                    movie.get().getDvdList().get(i).setAvailable(false);
                    movie.get().getDvdList().get(i).setStartDate(LocalDate.now());
                    movie.get().getDvdList().get(i).setEndDate(LocalDate.now().plusDays((long)rentDays));
                    movieService.updateMovie(movie.get());
                    String backUrl = "redirect:/moviepage/"+username+"/detail/" + movie.get().getId();
                    return backUrl;
                }
            }
        }
            redirectAttributes.addFlashAttribute("notAvailable" , "Terjadi Error Saat Membaca Data ");
            return "redirect:/moviepage/"+username+"/list";


    }

    @GetMapping("/{username}/returndvd/{id}/{code}")
    public String returnDVD(@PathVariable("id") String id , @PathVariable("code") String code,
                            RedirectAttributes redirectAttributes,
                            @PathVariable("username") String username){
        Optional<Movie> movieOptional =movieService.getMovieById(id);
        if(movieOptional.isPresent()){
            for(int i=0 ; i<movieOptional.get().getDvdList().size() ; i++){
                if(movieOptional.get().getDvdList().get(i).getCode().equals(code)){
                    movieOptional.get().getDvdList().get(i).setAvailable(true);
                    movieOptional.get().getDvdList().get(i).setStartDate(LocalDate.now());
                    movieOptional.get().getDvdList().get(i).setEndDate(LocalDate.now());
                    movieService.updateMovie(movieOptional.get());
                    String backUrl = "redirect:/moviepage/"+username+"/detail/" + movieOptional.get().getId();
                    return backUrl;
                }
            }
        }
        redirectAttributes.addFlashAttribute("notAvailable" , "Terjadi Error Saat Membaca Data ");
        return "redirect:/moviepage/"+username+"/list";

    }


}
