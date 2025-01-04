FROM node:18.20.4-alpine3.20 AS builder
# Add a work directory
WORKDIR /app

# Cache and Install dependencies
COPY package*.json .
RUN npm i

# Copy app files
COPY . .

# Build the app
RUN npm run build

# Bundle static assets with nginx
FROM nginx:1.21.0-alpine as production


# Copy built assets from builder
COPY --from=builder /app/dist /usr/share/nginx/html

# Add your nginx.conf
COPY docker/nginx/default.conf /etc/nginx/conf.d/default.conf

# Expose port
EXPOSE 80

# Start nginx
CMD ["nginx", "-g", "daemon off;"]