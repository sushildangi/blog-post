package com.luv2tech.audit;

import com.luv2tech.model.User;
import com.luv2tech.service.UserPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<User> {


    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equalsIgnoreCase("anonymousUser")) {
            return ((UserPrincipal) auth.getPrincipal()).getUser();
        } else {
            return null;
        }

    }

    @Override
    public Optional<User> getCurrentAuditor() {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return Optional.empty();
        }
        return Optional.of(currentUser);
    }
}
