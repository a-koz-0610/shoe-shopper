package org.wecancodeit.shoeshopperv2.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends Exception {

}
