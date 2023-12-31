package com.alta.service;

import com.alta.dto.ZnoDto;

import java.util.List;

/**
 * Interface for managing the Zno data.
 * Provides functionality to return, save, update, and delete Zno objects.
 */

public interface ZnoService {  // todo: check documentation.

    /**
     * Returns a list of all Zno objects available.
     *
     * @return A list of ZnoDto objects representing the available znos.
     */
    List<ZnoDto> findAll();

}
