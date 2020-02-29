package com.thimico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="mailto:thg.mnzs@gmail.com">Thiago Menezes</a>
 */

@RestController
@RequestMapping("api/rest/person")
public class PersonController {
    @Autowired
    private QueryResolver query;

    @Autowired
    private MutationResolver mutation;
}
