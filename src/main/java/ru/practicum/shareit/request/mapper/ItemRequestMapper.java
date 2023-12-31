package ru.practicum.shareit.request.mapper;

import lombok.AllArgsConstructor;
import ru.practicum.shareit.item.dto.ItemInRequestDto;
import ru.practicum.shareit.request.dto.CreateItemRequestDto;
import ru.practicum.shareit.request.dto.ItemRequestDto;
import ru.practicum.shareit.request.dto.ItemRequestResponseDto;
import ru.practicum.shareit.request.dto.ItemRequestWithItemsDto;
import ru.practicum.shareit.request.model.ItemRequest;
import ru.practicum.shareit.user.mapper.UserMapper;

import java.util.List;

@AllArgsConstructor
public class ItemRequestMapper {

    public static ItemRequestDto toDto(ItemRequest itemRequest) {
        return ItemRequestDto.builder()
                .id(itemRequest.getId())
                .description(itemRequest.getDescription())
                .requestor(UserMapper.toDto(itemRequest.getRequestor()))
                .created(itemRequest.getCreated())
                .build();
    }

    public static ItemRequest createItemRequestToItemRequest(CreateItemRequestDto createItemRequestDto) {
        return ItemRequest.builder()
                .description(createItemRequestDto.getDescription())
                .build();
    }

    public static ItemRequestResponseDto toItemRequestResponse(ItemRequest itemRequest) {
        return ItemRequestResponseDto.builder()
                .id(itemRequest.getId())
                .description(itemRequest.getDescription())
                .created(itemRequest.getCreated())
                .build();
    }

    public static ItemRequestWithItemsDto toItemRequestWithItemsDto(ItemRequest itemRequest, List<ItemInRequestDto> items) {
        return ItemRequestWithItemsDto.builder()
                .id(itemRequest.getId())
                .description(itemRequest.getDescription())
                .created(itemRequest.getCreated())
                .items(items)
                .build();
    }

}
