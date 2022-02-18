package com.example.WeatherPartiel.controller;

import com.example.WeatherPartiel.bean.Weather;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "METEO", description = "METEO")
@RequestMapping("/weathers")
public class WeatherPartielController {
    public static final List<Weather> weathers = new ArrayList<Weather>() {
        private static final long serialVersionUID = -3970206781360313502L;

        {
            add(new Weather(1,"Nice", "06000", "France","soleil"));
            add(new Weather(2,"Marseille", "13000", "France","pluie"));
            add(new Weather(3,"Bruxelles", "1000", "Belgique","soleil"));
        }
    };

    @ApiOperation(value = "Get list of Weathers", response = Iterable.class, tags = "getWeather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(
            name = "getWeather",
            method = RequestMethod.GET
    )
    public List<Weather> getWeather() {
        try {
            return weathers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Get list of Weathers", response = Iterable.class, tags = "getWeatherByPays")
    @RequestMapping(
            name = "getWeatherByPays",
            method = RequestMethod.GET,
            value = "pays/{pays}"
    )
    public List<Weather> getWeathersByPays(@PathVariable String pays){
        try {
            return weathers.stream()
                    .filter(weather -> pays.equals(weather.getPays()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Get list of Weathers", response = Iterable.class, tags = "getWeatherByNom")
    @RequestMapping(
            name = "getWeatherByNom",
            method = RequestMethod.GET,
            value = "nom/{nom}"
    )
    public List<Weather> getWeathersByNom(@PathVariable String nom){
        try {
            return weathers.stream()
                    .filter(weather -> nom.equals(weather.getNom()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Get list of Weathers", response = Iterable.class, tags = "getWeatherByCode")
    @RequestMapping(
            name = "getWeatherByCode",
            method = RequestMethod.GET,
            value = "code/{code}"
    )
    public List<Weather> getWeathersByCode(@PathVariable String code){
        try {
            return weathers.stream()
                    .filter(weather -> code.equals(weather.getCode()) )
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Get list of Weathers", response = Iterable.class, tags = "getWeatherByMeteo")
    @RequestMapping(
            name = "getWeatherByMeteo",
            method = RequestMethod.GET,
            value = "meteo/{meteo}"
    )
    public List<Weather> getWeathersByMeteo(@PathVariable String meteo){
        try {
            return weathers.stream()
                    .filter(weather -> meteo.equals(weather.getMeteo()))
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
