<script setup>
import { RouterLink } from 'vue-router'

defineProps({
  book: Object
})
</script>

<template>
  <tr class="text-center">
    <th>{{ book.isbn }}</th>
    <td>
      <RouterLink
        style="text-decoration: none"
        :to="{ name: 'book-view', query: { isbn: book.isbn } }"
      >
        {{ book.title }}
      </RouterLink>
    </td>
    <td>{{ book.author }}</td>
    <td>{{ book.price }}</td>
  </tr>
</template>

<style scoped></style>
