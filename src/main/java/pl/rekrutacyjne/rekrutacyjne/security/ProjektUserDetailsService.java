package pl.rekrutacyjne.rekrutacyjne.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.rekrutacyjne.rekrutacyjne.repositories.UserRepository;

public class ProjektUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    public ProjektUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo
                .findByUsernameIgnoreCase(username)
                .map(UserEntityDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
