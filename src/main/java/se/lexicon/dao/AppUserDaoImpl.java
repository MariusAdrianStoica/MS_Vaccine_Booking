package se.lexicon.dao;

import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoImpl implements AppUserDao{

    private List<AppUser> userStorage; //= new ArrayList<>(); - we make constructor down

    public AppUserDaoImpl(){
        userStorage= new ArrayList<>();

    }

    @Override
    public AppUser create(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("appUser was null");
        AppUser result = findByUsername(appUser.getUsername()); // looks for user in storage
        if (result!=null) {// check if username exists or no
            throw new IllegalArgumentException("username was duplicate");
        }
        userStorage.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        if (username== null) throw new IllegalArgumentException("username was null");
        for (AppUser appUser: userStorage){
            if (appUser.getUsername().equalsIgnoreCase(username)) return appUser;
        }
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(userStorage);

        /*List<AppUser> result = new ArrayList<>(userStorage);
        return result; */ //single return line
    }
}
