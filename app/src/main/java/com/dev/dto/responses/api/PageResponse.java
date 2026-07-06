package com.dev.dto.responses.api;

import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;

import java.util.Collection;

public class PageResponse<T> extends SuccessResponse<PageResponse.Payload<T>> {

    public PageResponse(String message, Page<T> data, HttpStatusCode status) {
        super(message, new Payload<>(data), status);
    }

    @Getter
    public static class Payload<T> {

        private final Collection<T> result;
        private final Metadata<T> metadata;

        public Payload(Page<T> page) {
            this.result = page.getContent();
            this.metadata = new Metadata<>(page);
        }

        @Getter
        public static class Metadata<T> {

            private final int size;
            private final int currentPage;
            private final int currentTotal;
            private final int totalPages;
            private final int totalElements;

            public Metadata(Page<T> page) {
                /*
                getNumberOfElements (number of elements in current page (page: 0 or page: 1))
                getTotalElements (number of all elements in collection (page's content))
                 */
                this.size = page.getSize();
                //pagination start index: 0 => plus 1 to return understandable value
                this.currentPage = page.getNumber() + 1;
                this.currentTotal = page.getNumberOfElements();
                this.totalPages = page.getTotalPages();
                this.totalElements = (int) page.getTotalElements();
            }
        }
    }
}